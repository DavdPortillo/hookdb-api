package com.winninginnovations.services;

import com.winninginnovations.DTO.GameAndSagaDTO;
import com.winninginnovations.DTO.GameDTO;
import com.winninginnovations.DTO.SagaDTO;
import com.winninginnovations.DTO.ScoreAverageResultDTO;
import com.winninginnovations.entity.*;
import com.winninginnovations.repository.*;
import com.winninginnovations.request.AvailabilityRequest;
import com.winninginnovations.request.GameFeatureRequest;
import com.winninginnovations.request.GameRequest;
import com.winninginnovations.request.ProductRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.winninginnovations.services.interfaces.IGameService;

import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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

    // Convert Saga to SagaDTO
    Saga saga = game.getSaga();
    SagaDTO sagaDTO = new SagaDTO();
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

    // Create GameAndSagaDTO
    GameAndSagaDTO gameAndSagaDTO = new GameAndSagaDTO();
    gameAndSagaDTO.setGame(game);
    gameAndSagaDTO.setSaga(sagaDTO);

    return gameAndSagaDTO;
  }

  @Override
  public Game findByIdGame(Long id) {
    LOG.info("Finding game by id: {}", id);
    return gameRepository.findById(id).orElse(null);
  }

  @Override
  public Game save(GameRequest gameRequest) {

    LOG.info("Saving game: {}", gameRequest);
    Game game = gameRequest.getGame();
    List<Long> platformsIds = gameRequest.getPlatformIds();
    Long crossplayId = gameRequest.getCrossplayId();
    List<Long> genreIds = gameRequest.getGenreIds();
    List<Long> developerIds = gameRequest.getDeveloperIds();
    List<Long> distributorIds = gameRequest.getDistributorIds();
    List<Long> dlcIds = gameRequest.getDlcIds();
    List<AvailabilityRequest> availabilityRequests = gameRequest.getAvailabilities();
    List<GameFeatureRequest> featureRequests = gameRequest.getGameFeatures();
    Saga saga = gameRequest.getSaga();
    // Guarda los requisitos mínimos del sistema
    SystemRequirement minimumSystemRequirement =
        systemRequirementRepository.save(gameRequest.getMinimumSystemRequirement());

    // Guarda los requisitos recomendados del sistema
    SystemRequirement recommendedSystemRequirement =
        systemRequirementRepository.save(gameRequest.getRecommendedSystemRequirement());

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

    if (availabilityRequests == null || availabilityRequests.isEmpty()) {
      throw new IllegalArgumentException("availabilityRequests no puede ser nulo o vacío");
    }

    if (featureRequests == null || featureRequests.isEmpty()) {
      throw new IllegalArgumentException("featureRequests no puede ser nulo o vacío");
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

    List<DLC> dlcs = null;
    if (dlcIds != null && !dlcIds.isEmpty()) {
      dlcs = dlcRepository.findAllById(dlcIds);
      if (dlcs.size() != dlcIds.size()) {
        throw new IllegalArgumentException("No se encontraron todos los DLCs especificados");
      }
    }

    if (saga != null) {
      // Busca la saga existente por su ID
      Optional<Saga> existingSaga = sagaRepository.findById(saga.getId());

      if (existingSaga.isPresent()) {
        // Si la saga ya existe, úsala
        game.setSaga(existingSaga.get());
      } else {
        // Si la saga no existe, crea una nueva
        Saga newSaga = new Saga();
        newSaga.setName(saga.getName());
        Saga savedSaga = sagaRepository.save(newSaga);
        game.setSaga(savedSaga);
      }
    }

    Crossplay crossplay =
        crossplayRepository
            .findById(crossplayId)
            .orElseThrow(
                () ->
                    new IllegalArgumentException("Crossplay no encontrado con id: " + crossplayId));

    List<Availability> availabilities = new ArrayList<>();
    for (AvailabilityRequest availabilityRequest : gameRequest.getAvailabilities()) {
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

    List<GameFeature> gameFeatures = new ArrayList<>();
    for (GameFeatureRequest gameFeatureRequest : gameRequest.getGameFeatures()) {
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
    List<Product> savedProducts = new ArrayList<>();
    for (ProductRequest productRequest : gameRequest.getProducts()) {
      Product product = new Product();
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

    // Asigna los productos al juego
    game.setProducts(savedProducts);

    // Asigna los productos al juego
    game.setProducts(savedProducts);

    game.setMinimumSystemRequirement(minimumSystemRequirement);
    game.setRecommendedSystemRequirement(recommendedSystemRequirement);
    game.setGameFeatures(gameFeatures);
    game.setPlatforms(platforms);
    game.setGenres(genres);
    game.setCrossplay(crossplay);
    game.setDevelopers(developers);
    game.setDistributors(distributors);
    game.setDlcs(dlcs);
    game.setAvailabilities(availabilities);
    return gameRepository.save(game);
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
