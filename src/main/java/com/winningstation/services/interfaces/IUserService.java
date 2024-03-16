package com.winningstation.services.interfaces;

import com.winningstation.dto.UpdateUserRequest;
import com.winningstation.dto.UserAdminDTO;
import com.winningstation.dto.UserInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.winningstation.entity.User;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interface que define los métodos que debe implementar la clase User.
 *
 * @author David Portillo Hoyos
 */
public interface IUserService {

  /**
   * Método que permite obtener un usuario por su ID.
   *
   * @param id ID del usuario.
   * @return El usuario con el ID especificado.
   */
  User findById(Long id);

  UserInfoDTO findUserInfoById(Long userId);

  /**
   * Método que permite guardar un usuario.
   *
   * @param user Usuario a guardar.
   * @return El usuario guardado.
   */
  User save(User user, MultipartFile file);

  /**
   * Método que permite eliminar un usuario.
   *
   * @param id ID del usuario a eliminar.
   */
  void delete(Long id);

  /**
   * Método que permite obtener todos los usuarios paginados.
   *
   * @return Lista de todos los usuarios paginados.
   */
  Page<User> findAll(Pageable pageable);

  /**
   * Método que permite buscar usuarios por su nombre.
   *
   * @param username Nombre del usuario.
   * @return Lista de usuarios con el nombre especificado.
   */
  Page<User> findByUsernameContaining(final String username, final Pageable pageable);

  /**
   * Método que permite buscar usuarios por su nombre.
   *
   * @param email Nombre del usuario.
   * @return Lista de usuarios con el nombre especificado.
   */
  Page<User> findByEmailContaining(final String email, final Pageable pageable);

  /**
   * Método que permite buscar usuarios por su correo.
   *
   * @param email Correo del usuario.
   * @return Lista de usuarios con el correo especificado.
   */
  User findByEmail(String email);

  /**
   * Método que permite actualizar un usuario.
   *
   * @param id ID del usuario a actualizar.
   * @param updateUserRequest Datos del usuario a actualizar.
   * @param file Archivo de imagen del usuario.
   * @return El usuario actualizado.
   */
  User updateUser(Long id, UpdateUserRequest updateUserRequest, MultipartFile file);

  Page<UserAdminDTO> findAllUsers(Pageable pageable);
}
