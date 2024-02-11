package com.winninginnovations.jwt;

import java.io.IOException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.winninginnovations.entity.Role;
import com.winninginnovations.entity.User;
import com.winninginnovations.repository.RoleRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Clase JwtTokenFilter que se encarga de filtrar las solicitudes HTTP y
 * establecer el contexto de autenticación. Esta clase se utiliza para validar
 * el token de acceso
 *
 * @author David Portillo Hoyos
 */
@Component
public class JwtTokenFilter extends OncePerRequestFilter {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenFilter.class);

	/**
	 * Utilidad para los tokens JWT.
	 */
	private final JwtTokenUtil jwtTokenUtil;

	/**
	 * Servicio para los detalles del usuario.
	 */
	private final UserDetailsService userDetailsService;

	/**
	 * Repositorio para los roles.
	 */
	private final RoleRepository roleRepository;

	/**
	 * Constructor para la inyección de dependencias.
	 *
	 * @param jwtTokenUtil       La utilidad para los tokens JWT.
	 * @param userDetailsService El servicio para los detalles del usuario.
	 * @param roleRepository     El repositorio para los roles.
	 */
	public JwtTokenFilter(JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService,
			RoleRepository roleRepository) {
		this.jwtTokenUtil = jwtTokenUtil;
		this.userDetailsService = userDetailsService;
		this.roleRepository = roleRepository;
	}

	/**
	 * Método para filtrar las solicitudes HTTP. Este método valida el token de
	 * acceso y establece el contexto de autenticación.
	 *
	 * @param request     La solicitud HTTP.
	 * @param response    La respuesta HTTP.
	 * @param filterChain La cadena de filtros.
	 * @throws ServletException Si ocurre un error en el servlet.
	 * @throws IOException      Si ocurre un error de entrada/salida.
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// Si la solicitud HTTP no tiene el encabezado Authorization, se pasa al
		// siguiente filtro
		if (!hasAuthorizationBearer(request)) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = getAccessToken(request);
		// Si el token de acceso no es válido, se pasa al siguiente filtro
		if (!jwtTokenUtil.validateToken(token)) {
			LOGGER.warn("Token de acceso no válido");
			filterChain.doFilter(request, response);
			return;
		}
		// Establece el contexto de autenticación
		try {
			setAuthenticationContext(token, request);
			filterChain.doFilter(request, response);
		} catch (Exception e) {
			throw new ServletException("Error al establecer el contexto de autenticación", e);
		}
	}

	/**
	 * Comprueba si la solicitud HTTP tiene el encabezado Authorization con el token
	 * de acceso.
	 *
	 * @param request La solicitud HTTP.
	 * @return Verdadero si el encabezado de autorización existe y comienza con
	 *         "Bearer", falso en caso contrario.
	 */
	private boolean hasAuthorizationBearer(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		return !ObjectUtils.isEmpty(header) && header.startsWith("Bearer");
	}

	/**
	 * Obtiene el token de acceso de la solicitud HTTP.
	 *
	 * @param request La solicitud HTTP.
	 * @return El token de acceso.
	 */
	public String getAccessToken(HttpServletRequest request) {
		String header = request.getHeader("Authorization");
		return header.split(" ")[1].trim();
	}

	/**
	 * Establece el contexto de autenticación.
	 *
	 * @param token   El token de acceso.
	 * @param request La solicitud HTTP.
	 */
	private void setAuthenticationContext(String token, HttpServletRequest request) {
		// Obtiene los detalles del usuario a partir del token de acceso
		User userDetails = getUserDetails(token);
		// Carga las autoridades del usuario
		UserDetails user = userDetailsService.loadUserByUsername(userDetails.getEmail());
		Collection<? extends GrantedAuthority> authorities = user.getAuthorities();

		// Establece el contexto de autenticación
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				authorities);

		// Establece los detalles de la solicitud HTTP
		authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

		// Establece la autenticación en el contexto de seguridad
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/**
	 * Obtiene los detalles del usuario a partir del token de acceso.
	 *
	 * @param token El token de acceso.
	 * @return Los detalles del usuario.
	 */
	private User getUserDetails(String token) {
		// Crea un nuevo objeto de detalles de usuario
		User userDetail = new User();
		// Obtiene el sujeto del token de acceso
		String[] jwtSubject = jwtTokenUtil.getSubject(token).split(",");

		// Establece los detalles del usuario a partir del sujeto del token
		userDetail.setId(Long.parseLong(jwtSubject[0]));
		userDetail.setUsername(jwtSubject[1]);
		userDetail.setPassword(jwtSubject[2]);
		// Busca el rol en la base de datos utilizando el ID
		Long roleId = Long.parseLong(jwtSubject[3]);
		Role role = roleRepository.findById(roleId).orElse(null);
		userDetail.setRole(role);

		userDetail.setEmail(jwtSubject[4]);

		// Devuelve los detalles del usuario
		return userDetail;
	}
}
