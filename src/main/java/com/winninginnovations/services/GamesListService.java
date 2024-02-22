package com.winninginnovations.services;

import com.winninginnovations.entity.GamesList;
import com.winninginnovations.entity.User;
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
 * @autor David Portillo Hoyos
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

  /**
   * Constructor de la clase.
   *
   * @param gamesListRepository Repositorio de la lista de juegos.
   */
  public GamesListService(GamesListRepository gamesListRepository, UserRepository userRepository) {
    this.gamesListRepository = gamesListRepository;
    this.userRepository = userRepository;
  }

  @Override
  public GamesList createGamesList(GamesList gamesList, Long idUser) {
    User user =
        userRepository
            .findById(idUser)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));
    gamesList.setUser(user);
    return gamesListRepository.save(gamesList);
  }
}
