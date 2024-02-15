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

  /** Repositorio de Language */
  private final LanguageRepository languageRepository;

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
      DLCRepository dlcRepository,
      LanguageRepository languageRepository) {
    this.gameRepository = gameRepository;
    this.platformRepository = platformRepository;
    this.crossplayRepository = crossplayRepository;
    this.genreRepository = genreRepository;
    this.developerRepository = developerRepository;
    this.distributorRepository = distributorRepository;
    this.dlcRepository = dlcRepository;
    this.languageRepository = languageRepository;
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
  public Game save(GameRequest gameRequest) {

    Game game = gameRequest.getGame();
    List<Long> platformsIds = gameRequest.getPlatformIds();
    Long crossplayId = gameRequest.getCrossplayId();
    List<Long> genreIds = gameRequest.getGenreIds();
    List<Long> developerIds = gameRequest.getDeveloperIds();
    List<Long> distributorIds = gameRequest.getDistributorIds();
    List<Long> dlcIds = gameRequest.getDlcIds();
    List<Long> languageIds = gameRequest.getLanguageIds();

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

    if (developerIds == null
        || developerIds.isEmpty()
        || developerIds.contains(null)
        || developerIds.contains(0L)) {
      throw new IllegalArgumentException(
          "developerId no puede ser nulo, vacío o contener null o 0");
    }

    if (distributorIds == null
        || distributorIds.isEmpty()
        || distributorIds.contains(null)
        || distributorIds.contains(0L)) {
      throw new IllegalArgumentException(
          "distributorId no puede ser nulo, vacío o contener null o 0");
    }

    if (languageIds == null
        || languageIds.isEmpty()
        || languageIds.contains(null)
        || languageIds.contains(0L)) {
      throw new IllegalArgumentException(
          "languageIds no puede ser nulo, vacío o contener null o 0");
    }

    List<Platform> platforms = platformRepository.findAllById(platformsIds);
    if (platforms.size() != platformsIds.size()) {
      throw new IllegalArgumentException("No se encontraron todas las plataformas especificadas");
    }

    List<Genre> genres = genreRepository.findAllById(genreIds);
    if (genres.size() != genreIds.size()) {
      throw new IllegalArgumentException("No se encontraron todos los géneros especificados");
    }

    List<Developer> developers = developerRepository.findAllById(developerIds);
    if (developers.size() != developerIds.size()) {
      throw new IllegalArgumentException(
          "No se encontraron todos los desarrolladores especificados");
    }

    List<Distributor> distributors = distributorRepository.findAllById(distributorIds);
    if (distributors.size() != distributorIds.size()) {
      throw new IllegalArgumentException(
          "No se encontraron todos los distribuidores especificados");
    }

    List<Language> languages = languageRepository.findAllById(languageIds);
    if (languages.size() != languageIds.size()) {
      throw new IllegalArgumentException("No se encontraron todos los idiomas especificados");
    }

    List<DLC> dlcs = null;
    if (dlcIds != null && !dlcIds.isEmpty()) {
      dlcs = dlcRepository.findAllById(dlcIds);
      if (dlcs.size() != dlcIds.size()) {
        throw new IllegalArgumentException("No se encontraron todos los DLCs especificados");
      }
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
    game.setLanguages(languages);
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
