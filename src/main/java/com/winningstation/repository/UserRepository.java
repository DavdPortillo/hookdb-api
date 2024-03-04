package com.winningstation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.winningstation.entity.User;

/**
 * Repositorio de usuario. Extiende de JpaRepository para proporcionar
 * métodos CRUD para la entidad Language.
 * 
 * @author David Portillo Hoyos
 * 
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
}