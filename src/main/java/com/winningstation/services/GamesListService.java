package com.winningstation.services;

import com.winningstation.dto.GameListDTO;
import com.winningstation.dto.ListDTO;
import com.winningstation.entity.*;
import com.winningstation.repository.GameRepository;
import com.winningstation.repository.GamesListRepository;
import com.winningstation.repository.UserRepository;
import com.winningstation.services.interfaces.IGamesListService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

  private final GameService gameService;

  /**
   * Constructor de la clase.
   *
   * @param gamesListRepository Repositorio de la lista de juegos.
   */
  public GamesListService(
      GamesListRepository gamesListRepository,
      UserRepository userRepository,
      GameRepository gameRepository,
      GameService gameService) {
    this.gamesListRepository = gamesListRepository;
    this.userRepository = userRepository;
    this.gameRepository = gameRepository;
    this.gameService = gameService;
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

  @Override
  public List<GameListDTO> getGamesByList(Long gamesListId) {
    LOGGER.info("Finding games for list {}", gamesListId);
    Optional<GamesList> gamesList = gamesListRepository.findById(gamesListId);

    if (gamesList.isPresent()) {
      return gamesList.get().getGames().stream()
          .map(
              game -> {
                GameListDTO gameResponse = new GameListDTO();
                gameResponse.setId(game.getId());
                gameResponse.setName(game.getTitle());
                gameResponse.setImage(game.getCover());
                gameResponse.setAlt(game.getAlt());
                gameResponse.setYear(game.getDate().getYear());
                gameResponse.setRate(gameService.calculateAverageScore(game.getId()));
                gameResponse.setGenres(
                    game.getGenres().stream().map(Genre::getName).collect(Collectors.toList()));
                gameResponse.setPlatforms(
                    game.getPlatforms().stream()
                        .map(Platform::getName)
                        .collect(Collectors.toList()));
                return gameResponse;
              })
          .collect(Collectors.toList());
    } else {
      throw new IllegalArgumentException("Games list not found");
    }
  }

  @Override
  public void deleteGameFromList(Long gamesListId, Long gameId) {
    GamesList gamesList =
        gamesListRepository
            .findById(gamesListId)
            .orElseThrow(
                () -> new IllegalArgumentException("Games list not found with id: " + gamesListId));
    Game game =
        gameRepository
            .findById(gameId)
            .orElseThrow(() -> new IllegalArgumentException("Game not found with id: " + gameId));

    if (gamesList.getGames().contains(game)) {
      gamesList.getGames().remove(game);
      gamesListRepository.save(gamesList);
    } else {
      throw new IllegalArgumentException("Game is not in the list");
    }
  }

  @Override
  public List<ListDTO> findListByUserId(Long userId) {
    LOGGER.info("Finding game list for user {}", userId);
    return gamesListRepository.findListByUserId(userId);
  }

  @Override
  public void deleteList(Long idList) {
    LOGGER.info("Deleting game list {}", idList);
    GamesList gamesList =
        gamesListRepository
            .findById(idList)
            .orElseThrow(() -> new IllegalArgumentException("Game list not found"));
    gamesListRepository.delete(gamesList);
  }

  @Override
  public String updateGamesListName(Long id, String newName) {
    // Buscar la lista de juegos
    GamesList gamesList =
        gamesListRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Game list not found"));

    // Actualizar el nombre
    gamesList.setName(newName);

    // Guardar la lista actualizada
    GamesList updatedGamesList = gamesListRepository.save(gamesList);

    // Devolver el nuevo nombre
    return updatedGamesList.getName();
  }

  @Override
  public List<ListDTO> findListByUserIdAndNamePattern(Long userId, String namePattern) {
    LOGGER.info("Finding game list for user {} with name pattern {}", userId, namePattern);
    return gamesListRepository.findListByUserIdAndNamePattern(userId, namePattern);
  }
}
