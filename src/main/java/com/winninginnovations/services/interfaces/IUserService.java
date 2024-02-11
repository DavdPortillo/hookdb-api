package com.winninginnovations.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.winninginnovations.entity.User;

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

	/**
	 * Método que permite guardar un usuario.
	 * 
	 * @param user Usuario a guardar.
	 * @return El usuario guardado.
	 */
	User save(User user);

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

}
