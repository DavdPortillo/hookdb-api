package com.winningstation.services;

import com.winningstation.dto.UpdateUserRequest;
import com.winningstation.dto.UserAdminDTO;
import com.winningstation.dto.UserInfoDTO;
import com.winningstation.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.winningstation.entity.User;
import com.winningstation.repository.UserRepository;
import com.winningstation.services.interfaces.IUserService;

import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * Implementación de los métodos de la interfaz IUserService.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class UserService implements IUserService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(UserService.class);

  /** Repositorio de User. */
  private final UserRepository userRepository;

  /** Repositorio para los roles. */
  private final RoleRepository roleRepository;

  /** Codificador de contraseñas. */
  private final BCryptPasswordEncoder passwordEncoder;

  private final FileStorageService fileStorageService;

  /**
   * Constructor de la clase.
   *
   * @param userRepository Repositorio de User.
   */
  public UserService(
      UserRepository userRepository,
      RoleRepository roleRepository,
      BCryptPasswordEncoder passwordEncoder,
      FileStorageService fileStorageService) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
    this.fileStorageService = fileStorageService;
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
  public User save(User user, MultipartFile file) {
    LOG.info("Saving user: {}", user);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    roleRepository.findById(2L).ifPresent(user::setRole);
    if (file != null) {
      String fileDownloadUri = fileStorageService.storeFileAndGenerateUri(file);
      user.setImage(fileDownloadUri);
    }
    return userRepository.save(user);
  }

  @Override
  public User updateUser(Long id, UpdateUserRequest updateUserRequest, MultipartFile file) {
    User updatedUser = updateUserRequest.getUpdatedUser();
    String oldPassword = updateUserRequest.getOldPassword();
    String newPassword = updateUserRequest.getNewPassword();

    User user =
        userRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

    if (updatedUser != null) {
      if (updatedUser.getUsername() != null) {
        User existingUser = userRepository.findByUsername(updatedUser.getUsername());
        if (existingUser == null || existingUser.getId().equals(user.getId())) {
          user.setUsername(updatedUser.getUsername());
        } else {
          throw new IllegalArgumentException("Username already exists");
        }
      }

      if (file != null && !file.isEmpty()) {
        String fileDownloadUri =
            fileStorageService.replaceFileAndGenerateUri(file, user.getImage());
        user.setImage(fileDownloadUri);
      } else{
        user.setImage(null);
      }

      if (updatedUser.getAlt() != null) {
        user.setAlt(updatedUser.getAlt());
      }

      if (updatedUser.getEmail() != null) {
        User existingUser = userRepository.findByEmail(updatedUser.getEmail());
        if (existingUser == null || existingUser.getId().equals(user.getId())) {
          user.setEmail(updatedUser.getEmail());
        } else {
          throw new IllegalArgumentException("Email already exists");
        }
      }

      if (newPassword != null && oldPassword != null) {
        if (passwordEncoder.matches(oldPassword, user.getPassword())) {
          if (newPassword.length() < 6 || newPassword.length() > 100) {
            throw new RuntimeException("Password must be between 6 and 100 characters");
          }
          user.setPassword(passwordEncoder.encode(newPassword));
        } else {
          throw new RuntimeException("Old password is incorrect");
        }
      }

      if (updatedUser.getCountry() != null && !updatedUser.getCountry().isEmpty()) {
        user.setCountry(updatedUser.getCountry());
      } else {
        user.setCountry(null);
      }

      if (updatedUser.getGender() != null && !updatedUser.getGender().isEmpty()) {
        user.setGender(updatedUser.getGender());
      } else {
        user.setGender(null);
      }

      if (updatedUser.getYear() != null) {
        user.setYear(updatedUser.getYear());
      } else {
        user.setYear(null);
      }

      if (updatedUser.getLanguage() != null && !updatedUser.getLanguage().isEmpty()) {
        user.setLanguage(updatedUser.getLanguage());
      } else {
        user.setLanguage(null);
      }

      if (updatedUser.getRole() != null) {
        user.setRole(updatedUser.getRole());
      }
    } else {
      throw new RuntimeException("No se proporcionó un usuario actualizado");
    }

    return userRepository.save(user);
  }

  @Override
  public UserInfoDTO findUserInfoById(Long userId) {
    LOG.info("Finding user info by id: {}", userId);
    return userRepository.findUserInfoById(userId);
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

  @Override
  public Page<UserAdminDTO> findAllUsers(Pageable pageable) {
    return userRepository.findAllUsers(pageable);
  }
}
