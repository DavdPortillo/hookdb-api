package com.winninginnovations.services.interfaces;

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
	 * Método que permite obtener todos los usuarios.
	 * 
	 * @return Lista de todos los usuarios.
	 */
	Iterable<User> findAll();

	/**
	 * Busca un cliente por su correo electrónico.
	 *
	 * @param email El correo electrónico del cliente.
	 * @return El cliente con el correo electrónico dado.
	 * @throws ClientServiceException Cliente no encontrado.
	 */
	User findByEmail(final String email);

}
