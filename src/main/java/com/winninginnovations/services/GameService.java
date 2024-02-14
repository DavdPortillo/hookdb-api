package com.winninginnovations.services;

import com.winninginnovations.entity.*;
import com.winninginnovations.repository.*;
import com.winninginnovations.request.GameRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.winninginnovations.services.interfaces.IGameService;

import jakarta.transaction.Transactional;

import java.util.List;

/**
 * Implementación de los métodos de la interfaz IGameService.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class GameService implements IGameService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(GameService.class);

  /** Repositorio de Game. */
  private final GameRepository gameRepository;

  /** Repositorio de plataforma */
  private final PlatformRepository platformRepository;

  /** Repositorio de Crossplay. */
  private final CrossplayRepository crossplayRepository;

  /** Repositorio de Genre. */
  private final GenreRepository genreRepository;

  /** Repositorio de Developer. */
  private final DeveloperRepository developerRepository;

  /** Repositorio de Distributor. */
  private final DistributorRepository distributorRepository;

  /** Repositorio de DLC */
  private final DLCRepository dlcRepository;

  /**
   * Constructor de la clase.
   *
   * @param gameRepository Repositorio de Game.
   */
  public GameService(
      GameRepository gameRepository,
      PlatformRepository platformRepository,
      CrossplayRepository crossplayRepository,
      GenreRepository genreRepository,
      DeveloperRepository developerRepository,
      DistributorRepository distributorRepository,
      DLCRepository dlcRepository) {
    this.gameRepository = gameRepository;
    this.platformRepository = platformRepository;
    this.crossplayRepository = crossplayRepository;
    this.genreRepository = genreRepository;
    this.developerRepository = developerRepository;
    this.distributorRepository = distributorRepository;
    this.dlcRepository = dlcRepository;
  }

  @Override
  public Game findById(Long id) {
    LOG.info("Finding game by id: {}", id);
    Game game = gameRepository.findById(id).orElse(null);
    if (game == null) {
      LOG.info("Game not found");
    }
    return game;
  }

  @Override
  public Game save(
      Game game,
      List<Long> platformsIds,
      Long crossplayId,
      List<Long> genreIds,
      List<Long> developerId,
      List<Long> distributorId,
      List<Long> dlcIds) {

    if (platformsIds == null
        || platformsIds.isEmpty()
        || platformsIds.contains(null)
        || platformsIds.contains(0L)) {
      throw new IllegalArgumentException(
          "platformsIds no puede ser nulo, vacío o contener null o 0");
    }

    if (crossplayId == null || crossplayId <= 0) {
      throw new IllegalArgumentException("crossplayId no puede ser nulo o menor o igual a 0");
    }

    if (genreIds == null
        || genreIds.isEmpty()
        || genreIds.contains(null)
        || genreIds.contains(0L)) {
      throw new IllegalArgumentException("genreIds no puede ser nulo, vacío o contener null o 0");
    }

    if (developerId == null
        || developerId.isEmpty()
        || developerId.contains(null)
        || developerId.contains(0L)) {
      throw new IllegalArgumentException(
          "developerId no puede ser nulo, vacío o contener null o 0");
    }

    if (distributorId == null
        || distributorId.isEmpty()
        || distributorId.contains(null)
        || distributorId.contains(0L)) {
      throw new IllegalArgumentException(
          "distributorId no puede ser nulo, vacío o contener null o 0");
    }

    if (dlcIds == null || dlcIds.isEmpty() || dlcIds.contains(null) || dlcIds.contains(0L)) {
      throw new IllegalArgumentException("dlcIds no puede ser nulo, vacío o contener null o 0");
    }

    List<Platform> platforms = platformRepository.findAllById(platformsIds);
    if (platforms.size() != platformsIds.size()) {
      throw new IllegalArgumentException("No se encontraron todas las plataformas especificadas");
    }

    List<Genre> genres = genreRepository.findAllById(genreIds);
    if (genres.size() != genreIds.size()) {
      throw new IllegalArgumentException("No se encontraron todos los géneros especificados");
    }

    List<Developer> developers = developerRepository.findAllById(developerId);
    if (developers.size() != developerId.size()) {
      throw new IllegalArgumentException(
          "No se encontraron todos los desarrolladores especificados");
    }

    List<Distributor> distributors = distributorRepository.findAllById(distributorId);
    if (distributors.size() != distributorId.size()) {
      throw new IllegalArgumentException(
          "No se encontraron todos los distribuidores especificados");
    }

    List<DLC> dlcs = dlcRepository.findAllById(dlcIds);
    if (dlcs.size() != dlcIds.size()) {
      throw new IllegalArgumentException("No se encontraron todos los DLCs especificados");
    }

    Crossplay crossplay =
        crossplayRepository
            .findById(crossplayId)
            .orElseThrow(
                () ->
                    new IllegalArgumentException("Crossplay no encontrado con id: " + crossplayId));

    game.setPlatforms(platforms);
    game.setGenres(genres);
    game.setCrossplay(crossplay);
    game.setDevelopers(developers);
    game.setDistributors(distributors);
    game.setDlcs(dlcs);

    return gameRepository.save(game);
  }

  @Override
  public void delete(Long id) {
    LOG.info("Deleting game by id: {}", id);
    gameRepository.deleteById(id);
  }

  @Override
  public Iterable<Game> findAll() {
    LOG.info("Finding all games");
    return gameRepository.findAll();
  }
}
