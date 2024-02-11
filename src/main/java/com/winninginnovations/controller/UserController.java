package com.winninginnovations.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        LOGGER.info("Creando Client: {}", user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        roleRepository.findById(2L).ifPresent(user::setRole);
        // Establece la fecha de registro al día actual
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        user.setRegisterDate(LocalDate.now().format(formatter));
        User createdUser = userService.save(user);
        LOGGER.info("Client creado: {}", createdUser);
        return createdUser;
    }

    /**
     * Obtiene todos los clientes.
     *
     * @param pageable La paginación.
     * @return Todos los clientes.
     */
    @GetMapping
    public ResponseEntity<Page<User>> getUsers(Pageable pageable) {
        LOGGER.info("Buscando todos los clientes");
        return ResponseEntity.ok(userService.findAll(pageable));
    }

    /**
     * Obtiene un cliente por su nombre.
     *
     * @param username El nombre del cliente.
     * @param pageable La paginación.
     * @return El cliente con el nombre especificado.
     */
    @GetMapping("/username")
    public ResponseEntity<Page<User>> getUsersByUsername(@RequestParam String username, Pageable pageable) {
        LOGGER.info("Buscando cliente por nombre: {}", username);
        return ResponseEntity.ok(userService.findByUsernameContaining(username, pageable));
    }

    /**
     * Obtiene un cliente por su correo.
     *
     * @param email    El correo del cliente.
     * @param pageable La paginación.
     * @return El cliente con el correo especificado.
     */
    @GetMapping("/email")
    public ResponseEntity<Page<User>> getUsersByEmail(@RequestParam String email, Pageable pageable) {
        LOGGER.info("Buscando cliente por correo: {}", email);
        return ResponseEntity.ok(userService.findByEmailContaining(email, pageable));
    }

    /**
     * Obtiene un cliente por su ID.
     *
     * @param id El ID del cliente.
     * @return El cliente con el ID especificado.
     */
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        LOGGER.info("Buscando cliente por ID: {}", id);
        return ResponseEntity.ok(userService.findById(id));
    }

    /**
     * Borra un cliente por su ID.
     *
     * @param id El ID del cliente.
     */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        LOGGER.info("Borrando cliente por ID: {}", id);
        userService.delete(id);
    }

}
