package com.winninginnovations.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.winninginnovations.entity.Role;
import com.winninginnovations.entity.User;
import com.winninginnovations.repository.RoleRepository;
import com.winninginnovations.services.interfaces.IUserService;

/**
 * Controlador para clientes
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * Servicio para los clientes.
	 */
	private final IUserService userService;

	/**
	 * Repositorio para los roles.
	 */
	private final RoleRepository roleRepository;

	/**
	 * Codificador de contraseñas.
	 */
	private final BCryptPasswordEncoder passwordEncoder;

	/**
	 * Constructor para la inyección de dependencias.
	 *
	 * @param userService     El servicio para los clientes.
	 * @param roleRepository  El repositorio para los roles.
	 * @param passwordEncoder El codificador de contraseñas.
	 */
	public UserController(IUserService userService, RoleRepository roleRepository,
			BCryptPasswordEncoder passwordEncoder) {
		this.userService = userService;
		this.roleRepository = roleRepository;
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * Logger para la clase
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	/**
	 * Crea un nuevo cliente.
	 *
	 * @param user El cliente a crear.
	 * @return El cliente creado.
	 * @throws ResponseStatusException Error al crear el cliente.
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		LOGGER.info("Creando Client: {}", user);
		try {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			Role userRole = roleRepository.findById(2L).orElse(null);
			if (userRole != null) {
				user.setRole(userRole);
			}
			User createdUser = userService.save(user);
			LOGGER.info("Client creado: {}", createdUser);
			return createdUser;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al crear User", e);
		}
	}

	/**
	 * Encuentra todos los clientes.
	 *
	 * @return Una lista de todos los clientes.
	 * @throws ResponseStatusException Error al buscar los clientes.
	 */
	@GetMapping
	public Iterable<User> findAll() {
		LOGGER.info("Buscando todos los Clients");
		try {
			Iterable<User> clients = userService.findAll();
			LOGGER.info("Clients encontrados");
			return clients;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error al buscar Clients", e);
		}
	}
}
