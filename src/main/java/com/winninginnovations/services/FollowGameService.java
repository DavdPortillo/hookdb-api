package com.winninginnovations.services;

import com.winninginnovations.dto.GameFollowDTO;
import com.winninginnovations.entity.FollowGame;
import com.winninginnovations.entity.Game;
import com.winninginnovations.entity.News;
import com.winninginnovations.entity.User;
import com.winninginnovations.repository.FollowGameRepository;
import com.winninginnovations.repository.GameRepository;
import com.winninginnovations.repository.UserRepository;
import com.winninginnovations.services.interfaces.IFollowGameService;
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

  public GameFollowDTO followOrIgnoreGame(Long userId, Long gameId, Integer action) {
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

    GameFollowDTO gameFollowDTO = new GameFollowDTO();
    gameFollowDTO.setId(game.getId());
    gameFollowDTO.setTitle(game.getTitle());

    List<Long> newsIds = game.getNews().stream().map(News::getId).collect(Collectors.toList());
    gameFollowDTO.setNewsIds(newsIds);

    return gameFollowDTO;
  }
}
