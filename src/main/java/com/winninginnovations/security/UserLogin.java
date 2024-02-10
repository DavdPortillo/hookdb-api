package com.winninginnovations.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.winninginnovations.entity.User;
import com.winninginnovations.services.UserService;

/**
 * Clase que implementa la interfaz UserDetailsService de Spring Security para
 * la autenticación de usuarios
 *
 * @author David Portillo Hoyos
 */
@Component
public class UserLogin implements UserDetailsService {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserLogin.class);

	/**
	 * Servicio de cliente
	 */
	private final UserService userService;

	/**
	 * Constructor
	 * 
	 * @param userService El servicio de cliente.
	 */
	public UserLogin(UserService userService) {
		this.userService = userService;
	}

	/**
	 * Carga los detalles del usuario por su nombre de usuario (en este caso, el
	 * correo electrónico).
	 *
	 * @param username El nombre de usuario (correo electrónico) del cliente.
	 * @return Los detalles del usuario.
	 * @throws UsernameNotFoundException si el cliente no se encuentra o no tiene
	 *                                   roles asignados.
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		LOGGER.info("Cargando detalles del usuario por nombre de usuario: {}", username);
		try {
			// Busca el cliente por su correo electrónico.
			User user = userService.findByEmail(username);
			// Si no se encuentra el cliente, lanza una excepción.
			if (user == null) {
				LOGGER.warn("Cliente no encontrado con nombre de usuario: {}", username);
				throw new UsernameNotFoundException("Cliente no encontrado con nombre de usuario: " + username);
			}
			// Crea una lista de autoridades.
			List<GrantedAuthority> authorities = new ArrayList<>();
			if (user.getRole() != null) {
				// Agrega el rol del cliente a la lista de autoridades.
				authorities.add(new SimpleGrantedAuthority(user.getRole().getName()));
			}

			// Si la lista de autoridades está vacía, lanza una excepción.
			if (authorities.isEmpty()) {
				LOGGER.warn("Error en el inicio de sesión: E-Mail '{}' no tiene roles asignados", username);
				throw new UsernameNotFoundException(
						"Error en el inicio de sesión: E-Mail '" + username + "' no tiene roles asignados");
			}
			// Crea los detalles del usuario.
			UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(),
					user.getPassword(), true, true, true, true, authorities);
			LOGGER.info("Detalles del usuario cargados exitosamente para el nombre de usuario: {}", username);
			return userDetails;
		} catch (UsernameNotFoundException e) {
			throw new UsernameNotFoundException(e.getMessage());
		}
	}
}
