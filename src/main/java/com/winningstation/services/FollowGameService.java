package com.winningstation.services;

import com.winningstation.entity.FollowGame;
import com.winningstation.entity.Game;
import com.winningstation.entity.User;
import com.winningstation.repository.FollowGameRepository;
import com.winningstation.repository.GameRepository;
import com.winningstation.repository.UserRepository;
import com.winningstation.services.interfaces.IFollowGameService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Servicio que maneja el seguimiento de juegos por parte de los usuarios.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class FollowGameService implements IFollowGameService {

  /** Logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(FollowGameService.class);

  /** Repositorio de seguimiento de juegos. */
  private final FollowGameRepository followGameRepository;

  /** Repositorio de juegos. */
  private final GameRepository gameRepository;

  /** Repositorio de usuarios. */
  private final UserRepository userRepository;

  /**
   * Constructor del servicio.
   *
   * @param followGameRepository Repositorio de seguimiento de juegos.
   * @param gameRepository Repositorio de juegos.
   * @param userRepository Repositorio de usuarios.
   */
  public FollowGameService(
      FollowGameRepository followGameRepository,
      GameRepository gameRepository,
      UserRepository userRepository) {
    this.followGameRepository = followGameRepository;
    this.gameRepository = gameRepository;
    this.userRepository = userRepository;
  }

  @Override
  public FollowGame followOrIgnoreGame(Long userId, Long gameId, Integer action) {
    LOGGER.info("User {} is {} game {}", userId, action == 1 ? "following" : "ignoring", gameId);
    User user =
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    Game game =
        gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));

    if (action != -1 && action != 1) {
      throw new RuntimeException("Invalid action. Must be -1 or 1.");
    }

    // Buscar si ya existe un seguimiento para este usuario y juego
    FollowGame followGame = followGameRepository.findByUserAndGame(user, game);
    if (followGame == null) {
      // Si no existe, crear uno nuevo
      followGame = new FollowGame();
      followGame.setUser(user);
      followGame.setGame(game);
    }

    // Si el usuario ya está realizando la acción sobre el juego, no hacer nada
    if (!action.equals(followGame.getIsFollowing())) {
      followGame.setIsFollowing(action);
      followGameRepository.save(followGame);
    }

    return followGame;
  }

  @Override
  public List<FollowGame> getFollowedOrIgnoredGames(Long userId) {
    LOGGER.info("Getting followed games for user {}", userId);
    User user =
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    return followGameRepository.findByUser(user);
  }

  @Override
  public List<FollowGame> getFollowedGames(Long userId) {
    LOGGER.info("Getting followed games for user {}", userId);
    User user =
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    return followGameRepository.findByUser(user).stream()
        .filter(followGame -> followGame.getIsFollowing() == 1)
        .collect(Collectors.toList());
  }

  @Override
  public List<FollowGame> getIgnoredGames(Long userId) {
    LOGGER.info("Getting ignored games for user {}", userId);
    User user =
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    return followGameRepository.findByUser(user).stream()
        .filter(followGame -> followGame.getIsFollowing() == -1)
        .collect(Collectors.toList());
  }

  @Override
  public Integer getFollowGame(Long userId, Long gameId) {
    LOGGER.info("Getting follow game for user {} and game {}", userId, gameId);
    User user =
        userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    if (user == null) {
      throw new RuntimeException("User not found");
    }
    Game game =
        gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
    if (game == null) {
      throw new RuntimeException("Game not found");
    }
    FollowGame followGame = followGameRepository.findByUserAndGame(user, game);
    if (followGame == null) {
      return 0; // Devuelve 0 si no se encuentra ningún registro de seguimiento
    }
    return followGame.getIsFollowing();
  }
}
