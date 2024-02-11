package com.winninginnovations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private final UserRepository userRepository;

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
    public Page<User> findAll(Pageable pageable) {
        LOG.info("Finding all users");
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> findByUsernameContaining(String username, Pageable pageable) {
        LOG.info("Finding user by username: {}", username);
        return userRepository.findByUsernameContaining(username, pageable);
    }

    @Override
    public Page<User> findByEmailContaining(String email, Pageable pageable) {
        LOG.info("Finding user by email: {}", email);
        return userRepository.findByEmailContaining(email, pageable);
    }

    @Override
    public User findByEmail(String email) {
        LOG.info("Finding user by email: {}", email);
        return userRepository.findByEmail(email);
    }
}
