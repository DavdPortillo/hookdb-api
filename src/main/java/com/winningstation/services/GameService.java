package com.winningstation.services;

import com.winningstation.dto.*;
import com.winningstation.entity.*;
import com.winningstation.projection.GamePopularityProjection;
import com.winningstation.repository.*;
import com.winningstation.request.AvailabilityRequest;
import com.winningstation.request.GameFeatureRequest;
import com.winningstation.request.GameRequest;
import com.winningstation.request.ProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.winningstation.services.interfaces.IGameService;

import jakarta.transaction.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

  /** Repositorio de Availability. */
  private final AvailabilityRepository availabilityRepository;

  /** Repositorio de Feature. */
  private final FeatureRepository featureRepository;

  /** Repositorio de NumberPlayer. */
  private final NumberPlayerRepository numberPlayerRepository;

  /** Repositorio de GameFeature. */
  private final GameFeatureRepository gameFeatureRepository;

  /** Repositorio de Saga. */
  private final SagaRepository sagaRepository;

  /** Repositorio de SystemRequirement. */
  private final SystemRequirementRepository systemRequirementRepository;

  /** Repositorio de Product. */
  private final ProductRepository productRepository;

  /** Repositorio de LogoProduct. */
  private final LogoProductRepository logoProductRepository;

  /** Repositorio de EditionProduct. */
  private final EditionProductRepository editionProductRepository;

  /** Repositorio de PlatformProduct. */
  private final PlatformProductRepository platformProductRepository;

  /** Repositorio de VendorProduct. */
  private final VendorProductRepository vendorProductRepository;

  /** Repositorio de RegionProduct. */
  private final RegionProductRepository regionProductRepository;

  /** Repositorio de KeysProduct. */
  private final KeysProductRepository keysProductRepository;

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
      LanguageRepository languageRepository,
      AvailabilityRepository availabilityRepository,
      FeatureRepository featureRepository,
      NumberPlayerRepository numberPlayerRepository,
      GameFeatureRepository gameFeatureRepository,
      SagaRepository sagaRepository,
      SystemRequirementRepository systemRequirementRepository,
      ProductRepository productRepository,
      LogoProductRepository logoProductRepository,
      EditionProductRepository editionProductRepository,
      PlatformProductRepository platformProductRepository,
      VendorProductRepository vendorProductRepository,
      RegionProductRepository regionProductRepository,
      KeysProductRepository keysProductRepository) {
    this.gameRepository = gameRepository;
    this.platformRepository = platformRepository;
    this.crossplayRepository = crossplayRepository;
    this.genreRepository = genreRepository;
    this.developerRepository = developerRepository;
    this.distributorRepository = distributorRepository;
    this.dlcRepository = dlcRepository;
    this.languageRepository = languageRepository;
    this.availabilityRepository = availabilityRepository;
    this.featureRepository = featureRepository;
    this.numberPlayerRepository = numberPlayerRepository;
    this.gameFeatureRepository = gameFeatureRepository;
    this.sagaRepository = sagaRepository;
    this.systemRequirementRepository = systemRequirementRepository;
    this.productRepository = productRepository;
    this.logoProductRepository = logoProductRepository;
    this.editionProductRepository = editionProductRepository;
    this.platformProductRepository = platformProductRepository;
    this.vendorProductRepository = vendorProductRepository;
    this.regionProductRepository = regionProductRepository;
    this.keysProductRepository = keysProductRepository;
  }

  @Override
  public GameAndSagaDTO findById(Long id) {
    LOG.info("Finding game by id: {}", id);
    Game game = gameRepository.findById(id).orElse(null);
    if (game == null) {
      LOG.info("Game not found");
      return null;
    }

    // Si el juego aún no se ha lanzado, incrementa el contador de popularidad

    game.setPopularity(game.getPopularity() + 1);
    gameRepository.save(game);

    return convertToGameAndSagaDTO(game);
  }

  @Override
  public Game findByIdGame(Long id) {
    LOG.info("Finding game by id: {}", id);
    return gameRepository.findById(id).orElse(null);
  }

  @Override
  public GameAndSagaDTO save(GameRequest gameRequest) {
    LOG.info("Saving game: {}", gameRequest);

    Game game = gameRequest.getGame();
    game.setMinimumSystemRequirement(
        systemRequirementRepository.save(gameRequest.getMinimumSystemRequirement()));
    game.setRecommendedSystemRequirement(
        systemRequirementRepository.save(gameRequest.getRecommendedSystemRequirement()));
    game.setPlatforms(
        validateAndGetEntities(gameRequest.getPlatformIds(), platformRepository, "plataformas"));
    game.setGenres(validateAndGetEntities(gameRequest.getGenreIds(), genreRepository, "géneros"));
    game.setDevelopers(
        validateAndGetEntities(
            gameRequest.getDeveloperIds(), developerRepository, "desarrolladores"));
    game.setDistributors(
        validateAndGetEntities(
            gameRequest.getDistributorIds(), distributorRepository, "distribuidores"));
    game.setDlcs(validateAndGetEntities(gameRequest.getDlcIds(), dlcRepository, "DLCs"));
    game.setCrossplay(
        crossplayRepository
            .findById(gameRequest.getCrossplayId())
            .orElseThrow(
                () ->
                    new IllegalArgumentException(
                        "Crossplay no encontrado con id: " + gameRequest.getCrossplayId())));
    game.setAvailabilities(createAvailabilities(gameRequest.getAvailabilities(), game));
    game.setSaga(getOrCreateSaga(gameRequest.getSaga()));
    game.setGameFeatures(createGameFeatures(gameRequest.getGameFeatures()));

    Game savedGame = gameRepository.save(game);
    savedGame.setProducts(createProducts(gameRequest.getProducts(), savedGame));

    return convertToGameAndSagaDTO(savedGame);
  }

  public GameAndSagaDTO convertToGameAndSagaDTO(Game game) {
    Saga saga = game.getSaga();
    SagaDTO sagaDTO = new SagaDTO();

    if (saga != null) {
      sagaDTO.setId(saga.getId());
      sagaDTO.setName(saga.getName());
      sagaDTO.setGames(
          saga.getGames().stream()
              .map(
                  g -> {
                    GameDTO gDTO = new GameDTO();
                    gDTO.setId(g.getId());
                    gDTO.setTitle(g.getTitle());
                    gDTO.setDate(g.getDate());
                    return gDTO;
                  })
              .collect(Collectors.toList()));
    }

    // Create GameAndSagaDTO
    GameAndSagaDTO gameAndSagaDTO = new GameAndSagaDTO();
    gameAndSagaDTO.setGame(game);
    gameAndSagaDTO.setSaga(sagaDTO);

    return gameAndSagaDTO;
  }

  private <T> List<T> validateAndGetEntities(
      List<Long> ids, JpaRepository<T, Long> repository, String entityName) {
    if (ids != null && !ids.isEmpty()) {
      List<T> entities = repository.findAllById(ids);
      if (entities.size() != ids.size()) {
        throw new IllegalArgumentException(
            "No se encontraron todos los " + entityName + " especificados");
      }
      return entities;
    }
    return null;
  }

  private Saga getOrCreateSaga(Saga saga) {
    if (saga == null) {
      return null;
    }

    return sagaRepository
        .findById(saga.getId())
        .orElseGet(
            () -> {
              Saga newSaga = new Saga();
              newSaga.setName(saga.getName());
              return sagaRepository.save(newSaga);
            });
  }

  private List<Availability> createAvailabilities(
      List<AvailabilityRequest> availabilityRequests, Game game) {
    if (availabilityRequests == null || availabilityRequests.isEmpty()) {
      throw new IllegalArgumentException("La lista de disponibilidades no puede ser nula ni vacía");
    }
    List<Availability> availabilities = new ArrayList<>();
    for (AvailabilityRequest availabilityRequest : availabilityRequests) {
      Language language =
          languageRepository
              .findById(availabilityRequest.getLanguageId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "Idioma no encontrado con id: " + availabilityRequest.getLanguageId()));
      Availability availability = new Availability();
      availability.setInterfaceLanguage(availabilityRequest.getInterfaceLanguage());
      availability.setSubtitleLanguage(availabilityRequest.getSubtitleLanguage());
      availability.setAudioLanguage(availabilityRequest.getAudioLanguage());
      availability.setLanguage(language);
      availability.setGame(game);
      availabilities.add(availability);
      availabilityRepository.save(
          availability); // Guarda la entidad Availability en la base de datos
    }
    return availabilities;
  }

  private List<GameFeature> createGameFeatures(List<GameFeatureRequest> gameFeatureRequests) {
    if (gameFeatureRequests == null || gameFeatureRequests.isEmpty()) {
      throw new IllegalArgumentException(
          "La lista de características del juego no puede ser nula ni vacía");
    }
    List<GameFeature> gameFeatures = new ArrayList<>();
    for (GameFeatureRequest gameFeatureRequest : gameFeatureRequests) {
      Feature feature =
          featureRepository
              .findById(gameFeatureRequest.getFeatureId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "Feature no encontrada con id: " + gameFeatureRequest.getFeatureId()));
      NumberPlayer numberPlayer = null;
      if (gameFeatureRequest.getNumberPlayerId() != null) {
        numberPlayer =
            numberPlayerRepository
                .findById(gameFeatureRequest.getNumberPlayerId())
                .orElseThrow(
                    () ->
                        new IllegalArgumentException(
                            "NumberPlayer no encontrado con id: "
                                + gameFeatureRequest.getNumberPlayerId()));
      }
      GameFeature gameFeature = new GameFeature();
      gameFeature.setFeature(feature);
      gameFeature.setNumberPlayers(numberPlayer);
      gameFeature =
          gameFeatureRepository.save(
              gameFeature); // Guarda la entidad GameFeature en la base de datos
      gameFeatures.add(gameFeature);
    }
    return gameFeatures;
  }

  private List<Product> createProducts(List<ProductRequest> productRequests, Game game) {
    if (productRequests == null || productRequests.isEmpty()) {
      throw new IllegalArgumentException("La lista de productos no puede ser nula ni vacía");
    }
    List<Product> savedProducts = new ArrayList<>();
    for (ProductRequest productRequest : productRequests) {
      Product product = new Product();
      product.setGame(game); // Asociar el producto con el juego
      product.setPrice(productRequest.getPrice());
      product.setLink(productRequest.getLink());
      product.setLogoProduct(
          logoProductRepository.findById(productRequest.getLogoProductId()).orElse(null));
      product.setEditionProduct(
          editionProductRepository.findById(productRequest.getEditionProductId()).orElse(null));
      product.setPlatformProduct(
          platformProductRepository.findById(productRequest.getPlatformProductId()).orElse(null));
      product.setVendorProduct(
          vendorProductRepository.findById(productRequest.getVendorProductId()).orElse(null));
      product.setRegionProduct(
          regionProductRepository.findById(productRequest.getRegionProductId()).orElse(null));
      product.setKeysProduct(
          keysProductRepository.findById(productRequest.getKeysProductId()).orElse(null));
      Product savedProduct = productRepository.save(product);
      savedProducts.add(savedProduct);
    }
    return savedProducts;
  }

  public ScoreAverageResultDTO calculateAverageScore(Long gameId) {

    LOG.info("Calculating average score of game with id: {}", gameId);

    Game game =
        gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));

    // Obtén todas las puntuaciones del juego
    List<GameScore> gameScores = game.getGameScores();

    // Calcula la puntuación media
    Double averageScore = gameScores.stream().mapToInt(GameScore::getScore).average().orElse(0.0);

    ScoreAverageResultDTO result = new ScoreAverageResultDTO();
    result.setAverageScore(averageScore);
    result.setScoreCount(gameScores.size());

    return result;
  }

  public ScoreAverageResultDTO calculateAverageScoreOfLast100(Long gameId) {

    LOG.info("Calculating average score of last 100 of game with id: {}", gameId);

    Game game =
        gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));

    // Obtén todas las puntuaciones del juego
    List<GameScore> gameScores = game.getGameScores();

    // Ordena las puntuaciones por ID y selecciona las últimas 100
    List<GameScore> last100GameScores =
        gameScores.stream()
            .sorted(Comparator.comparing(GameScore::getId).reversed())
            .limit(100)
            .toList();

    // Calcula la puntuación media de las últimas 100 puntuaciones
    Double averageScoreOfLast100 =
        last100GameScores.stream().mapToInt(GameScore::getScore).average().orElse(0.0);

    ScoreAverageResultDTO result = new ScoreAverageResultDTO();
    result.setAverageScore(averageScoreOfLast100);
    result.setScoreCount(last100GameScores.size());

    return result;
  }

  @Override
  public List<GamePopularityProjection> findTop5ByDateAfterAndOrderByPopularityDesc() {
    LOG.info("Finding top 5 popular unreleased games");
    return gameRepository.findTop5ByDateAfterAndOrderByPopularityDesc(
        LocalDate.now(), PageRequest.of(0, 5));
  }

  @Override
  public List<GamePopularityProjection> findByDateAfterAndOrderByPopularityDesc() {
    LOG.info("Finding all popular unreleased games");
    return gameRepository.findByDateAfterAndOrderByPopularityDesc(LocalDate.now());
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
