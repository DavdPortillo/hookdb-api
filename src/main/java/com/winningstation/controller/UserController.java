package com.winningstation.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.winningstation.entity.User;
import com.winningstation.repository.RoleRepository;
import com.winningstation.services.interfaces.IUserService;

/**
 * Controlador para clientes
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/user")
public class UserController {

  /** Servicio para los clientes. */
  private final IUserService userService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param userService El servicio para los clientes.
   */
  public UserController(IUserService userService) {
    this.userService = userService;
  }

  /**
   * Crea un nuevo cliente.
   *
   * @param user El cliente a crear.
   * @return El cliente creado.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public User create(@RequestBody User user) {

    return userService.save(user);
  }

  /**
   * Obtiene todos los clientes.
   *
   * @param pageable La paginación.
   * @return Todos los clientes.
   */
  @GetMapping
  public ResponseEntity<Page<User>> getUsers(Pageable pageable) {
    return ResponseEntity.ok(userService.findAll(pageable));
  }

  /**
   * Obtiene un cliente por su nombre.
   *
   * @param username El nombre del cliente.
   * @param pageable La paginación.
   * @return El cliente con el nombre especificado.
   */
  @GetMapping("/username/{username}")
  public ResponseEntity<Page<User>> getUsersByUsername(
      @PathVariable String username, Pageable pageable) {
    return ResponseEntity.ok(userService.findByUsernameContaining(username, pageable));
  }

  /**
   * Obtiene un cliente por su correo.
   *
   * @param email El correo del cliente.
   * @param pageable La paginación.
   * @return El cliente con el correo especificado.
   */
  @GetMapping("/email/{email}")
  public ResponseEntity<Page<User>> getUsersByEmail(@PathVariable String email, Pageable pageable) {
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
    userService.delete(id);
  }

  /**
   * Actualiza un cliente por su ID.
   *
   * @param id El ID del cliente.
   * @param updatedUser El cliente actualizado.
   * @param oldPassword La contraseña antigua.
   * @param newPassword La contraseña nueva.
   * @return El cliente actualizado.
   */
  @PutMapping("/{id}")
  public ResponseEntity<User> updateUser(
      @PathVariable Long id,
      @RequestBody User updatedUser,
      @RequestParam(required = false) String oldPassword,
      @RequestParam(required = false) String newPassword) {
    User user = userService.updateUser(id, updatedUser, oldPassword, newPassword);
    return ResponseEntity.ok(user);
  }
}
