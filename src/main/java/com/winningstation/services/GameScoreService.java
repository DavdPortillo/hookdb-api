package com.winningstation.services;

import com.winningstation.entity.Game;
import com.winningstation.entity.GameScore;
import com.winningstation.entity.User;
import com.winningstation.repository.GameRepository;
import com.winningstation.repository.GameScoreRepository;
import com.winningstation.repository.UserRepository;
import com.winningstation.services.interfaces.IGameScoreService;
import com.winningstation.socket.AvgScore100SocketHandler;
import com.winningstation.socket.AvgScoreSocketHandler;
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

  private final AvgScoreSocketHandler avgScoreSocketHandler;

  private final AvgScore100SocketHandler avgScore100SocketHandler;

  /**
   * Constructor de la clase.
   *
   * @param gameScoreRepository Repositorio de la puntuación de los juegos.
   */
  public GameScoreService(
      GameScoreRepository gameScoreRepository,
      UserRepository userRepository,
      GameRepository gameRepository,
      AvgScoreSocketHandler avgScoreSocketHandler,
      AvgScore100SocketHandler avgScore100SocketHandler) {
    this.gameScoreRepository = gameScoreRepository;
    this.userRepository = userRepository;
    this.gameRepository = gameRepository;
    this.avgScoreSocketHandler = avgScoreSocketHandler;
    this.avgScore100SocketHandler = avgScore100SocketHandler;
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

    avgScoreSocketHandler.sendScoreToGameSessions(gameId);
    avgScore100SocketHandler.sendLast100ScoresUpdate(gameId);
    return gameScoreRepository.save(gameScore);
  }

  public GameScore findGameScoreByUserIdAndGameId(Long userId, Long gameId) {
    LOGGER.info("Finding game score for user {} and game {}", userId, gameId);
    User user =
            userRepository
                    .findById(userId)
                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
    Game game =
            gameRepository
                    .findById(gameId)
                    .orElseThrow(() -> new IllegalArgumentException("Game not found"));
      return gameScoreRepository.findByUserAndGame(user, game);
  }
}