package com.winninginnovations.services;

import com.winninginnovations.entity.Game;
import com.winninginnovations.entity.GameScore;
import com.winninginnovations.entity.User;
import com.winninginnovations.repository.GameRepository;
import com.winninginnovations.repository.GameScoreRepository;
import com.winninginnovations.repository.UserRepository;
import com.winninginnovations.services.interfaces.IGameScoreService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Servicio que permite realizar operaciones sobre la puntuación de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class GameScoreService implements IGameScoreService {

  /** Logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(GameScoreService.class);

  /** Repositorio de la puntuación de los juegos. */
  private final GameScoreRepository gameScoreRepository;

  /** Repositorio de usuario. */
  private final UserRepository userRepository;

  /** Repositorio de juego. */
  private final GameRepository gameRepository;

  /**
   * Constructor de la clase.
   *
   * @param gameScoreRepository Repositorio de la puntuación de los juegos.
   */
  public GameScoreService(
      GameScoreRepository gameScoreRepository,
      UserRepository userRepository,
      GameRepository gameRepository) {
    this.gameScoreRepository = gameScoreRepository;
    this.userRepository = userRepository;
    this.gameRepository = gameRepository;
  }

  public GameScore createOrUpdateGameScore(Long userId, Long gameId, int score) {

    LOGGER.info("Creating or updating game score for user {} and game {}", userId, gameId);

    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    Game game =
        gameRepository
            .findById(gameId)
            .orElseThrow(() -> new IllegalArgumentException("Game not found"));

    GameScore gameScore = gameScoreRepository.findByUserAndGame(user, game);
    if (gameScore == null) {
      gameScore = new GameScore();
      gameScore.setUser(user);
      gameScore.setGame(game);
    }
    gameScore.setScore(score);

    return gameScoreRepository.save(gameScore);
  }
}
