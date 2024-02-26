package com.winningstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.winningstation.entity.User;
import com.winningstation.jwt.AuthRequest;
import com.winningstation.jwt.AuthResponse;
import com.winningstation.jwt.JwtTokenFilter;
import com.winningstation.jwt.JwtTokenUtil;
import com.winningstation.services.UserService;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Controlador para la autenticación de los clientes. Proporciona endpoints para
 * iniciar sesión y autenticar a los clientes.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	/**
	 * Utilidad para los tokens JWT.
	 */
	private final JwtTokenUtil jwtTokenUtil;

	/**
	 * Servicio para los clientes.
	 */
	private final UserService userService;

	/**
	 * Filtro para los tokens JWT.
	 */
	private final JwtTokenFilter jwtTokenFilter;

	/**
	 * Codificador de contraseñas.
	 */
	private final BCryptPasswordEncoder passwordEncoder;

	/**
	 * Constructor para la inyección de dependencias.
	 *
	 * @param jwtTokenUtil    La utilidad para los tokens JWT.
	 * @param clientService   El servicio para los clientes.
	 * @param jwtTokenFilter  El filtro para los tokens JWT.
	 * @param passwordEncoder El codificador de contraseñas.
	 */
	public LoginController(JwtTokenUtil jwtTokenUtil, UserService userService, JwtTokenFilter jwtTokenFilter,
			BCryptPasswordEncoder passwordEncoder) {
		this.jwtTokenUtil = jwtTokenUtil;
		this.userService = userService;
		this.jwtTokenFilter = jwtTokenFilter;
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * Inicia sesión un cliente.
	 *
	 * @param authRequest La solicitud de autenticación del cliente.
	 * @return La respuesta de autenticación del cliente.
	 */
	@PostMapping
	public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
		LOGGER.info("Autenticando Client con email: {}", authRequest.getEmail());
		try {
			User user = userService.findByEmail(authRequest.getEmail());

			if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
				LOGGER.warn("Contraseña incorrecta para el email: {}", authRequest.getEmail());
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}

			String accessToken = jwtTokenUtil.generateToken(user);

			AuthResponse authResponse = new AuthResponse(user.getId(), user.getUsername(), authRequest.getEmail(),
					user.getPassword(), user.getRole().getId().toString(), accessToken);

			LOGGER.info("Client autenticado exitosamente con email: {}", authRequest.getEmail());
			return ResponseEntity.ok(authResponse);

		} catch (BadCredentialsException e) {
			LOGGER.error("Error al autenticar Client", e);
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

	/**
	 * Autentica a un cliente.
	 *
	 * @param request La solicitud HTTP. Contiene el token de acceso.
	 * @return La respuesta de autenticación del cliente.
	 */
	@GetMapping("/authenticate")
	public ResponseEntity<AuthResponse> authenticate(HttpServletRequest request) {
		LOGGER.info("Autenticando Client con token de acceso");
		try {
			String token = jwtTokenFilter.getAccessToken(request);
			if (token == null) {
				LOGGER.warn("Token de acceso no encontrado");
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}

			String subject = jwtTokenUtil.getSubject(token);
			String email = subject.split(",")[4];

			User user = userService.findByEmail(email);
			if (user == null) {
				LOGGER.warn("No se encontró Client con email: {}", email);
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
			}

			AuthResponse authResponse = new AuthResponse(user.getId(), user.getUsername(), user.getEmail(),
					user.getPassword(), user.getRole().getId().toString(), token);

			LOGGER.info("Client autenticado exitosamente con email: {}", email);
			return ResponseEntity.ok(authResponse);
		} catch (Exception e) {
			LOGGER.error("Error al autenticar Client", e);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}