package com.winninginnovations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.winninginnovations.entity.User;
import com.winninginnovations.repository.UserRepository;
import com.winninginnovations.services.interfaces.IUserService;

import jakarta.transaction.Transactional;

/**
 * Implementación de los métodos de la interfaz IUserService.
 * 
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class UserService implements IUserService {

	/**
	 * Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

	/**
	 * Repositorio de User.
	 */
	private UserRepository userRepository;

	/**
	 * Constructor de la clase.
	 * 
	 * @param userRepository Repositorio de User.
	 */
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User findById(Long id) {
		LOG.info("Finding user by id: {}", id);
		User user = userRepository.findById(id).orElse(null);
		if (user == null) {
			LOG.info("User not found");
		}
		return user;

	}

	@Override
	public User save(User user) {
		LOG.info("Saving user: {}", user);
		return userRepository.save(user);
	}

	@Override
	public void delete(Long id) {
		LOG.info("Deleting user by id: {}", id);
		userRepository.deleteById(id);

	}

	@Override
	public Iterable<User> findAll() {
		LOG.info("Finding all userss");
		return userRepository.findAll();
	}

}
