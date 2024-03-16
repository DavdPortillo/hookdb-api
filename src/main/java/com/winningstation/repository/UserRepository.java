package com.winningstation.repository;

import com.winningstation.dto.UserAdminDTO;
import com.winningstation.dto.UserInfoDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.winningstation.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repositorio de usuario. Extiende de JpaRepository para proporcionar métodos CRUD
 *
 * @author David Portillo Hoyos
 */
public interface UserRepository extends JpaRepository<User, Long> {

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
   * Método que permite buscar un usuario por su nombre.
   *
   * @param email Nombre del usuario.
   * @return El usuario con el nombre especificado.
   */
  User findByEmail(final String email);

  @Query(
      "SELECT new  com.winningstation.dto.UserInfoDTO(u.username, u.email, u.country, "
          + "u.year, u.image, u.language, u.alt,u.registerDate) "
          + "FROM User u "
          + "WHERE u.id = :userId")
  UserInfoDTO findUserInfoById(@Param("userId") Long userId);

  @Query("SELECT new com.winningstation.dto.UserAdminDTO(u.id, u.username, u.email) FROM User u")
  Page<UserAdminDTO> findAllUsers(Pageable pageable);
}
