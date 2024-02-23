package com.winninginnovations.services;

import com.winninginnovations.entity.Game;
import com.winninginnovations.entity.GamesList;
import com.winninginnovations.entity.User;
import com.winninginnovations.repository.GameRepository;
import com.winninginnovations.repository.GamesListRepository;
import com.winninginnovations.repository.UserRepository;
import com.winninginnovations.services.interfaces.IGamesListService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que permite realizar operaciones sobre la lista de juegos.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class GamesListService implements IGamesListService {

  /** Logger. */
  private static final Logger LOGGER = LoggerFactory.getLogger(GamesListService.class);

  /** Repositorio de la lista de juegos. */
  private final GamesListRepository gamesListRepository;

  /** Repositorio de usuario. */
  private final UserRepository userRepository;

  /** Repositorio de juego. */
  private final GameRepository gameRepository;

  /**
   * Constructor de la clase.
   *
   * @param gamesListRepository Repositorio de la lista de juegos.
   */
  public GamesListService(
      GamesListRepository gamesListRepository,
      UserRepository userRepository,
      GameRepository gameRepository) {
    this.gamesListRepository = gamesListRepository;
    this.userRepository = userRepository;
    this.gameRepository = gameRepository;
  }

  @Override
  public GamesList createGamesList(GamesList gamesList, Long idUser) {
    LOGGER.info("Creating game list for user {}", idUser);

    User user =
        userRepository
            .findById(idUser)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

    GamesList existingGamesList = gamesListRepository.findByNameAndUser(gamesList.getName(), user);
    if (existingGamesList != null) {
      throw new IllegalArgumentException(
          "A games list with this name already exists for this user");
    }

    gamesList.setUser(user);
    return gamesListRepository.save(gamesList);
  }

  @Override
  public GamesList addGameToList(Long idList, Long idUser, Long idGame) {
    LOGGER.info("Adding game {} to list {} for user {}", idGame, idList, idUser);
    GamesList gamesList =
        gamesListRepository
            .findById(idList)
            .orElseThrow(() -> new IllegalArgumentException("Game list not found"));
    Game game =
        gameRepository
            .findById(idGame)
            .orElseThrow(() -> new IllegalArgumentException("Game not found"));
    User user =
        userRepository
            .findById(idUser)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    if (!gamesList.getUser().equals(user)) {
      throw new IllegalArgumentException("User does not own the game list");
    }
    if (gamesList.getGames().contains(game)) {
      throw new IllegalArgumentException("Game is already in the list");
    }
    gamesList.getGames().add(game);
    return gamesListRepository.save(gamesList);
  }
}
