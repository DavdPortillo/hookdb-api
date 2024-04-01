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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.winningstation.services.interfaces.IGameService;

import jakarta.transaction.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.*;
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

  /** Repositorio de GameScore. */
  private final GameScoreRepository gameScoreRepository;

  /** Repositorio de GamesList. */
  private final GamesListRepository gamesListRepository;

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

  /** Repositorio de News */
  private final NewsRepository newsRepository;

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

  /** Repositorio de VendorProduct. */
  private final VendorProductRepository vendorProductRepository;

  /** Repositorio de EditionProduct. */
  private final EditionProductRepository editionProductRepository;

  /** Repositorio de PlatformProduct. */
  private final PlatformProductRepository platformProductRepository;


  /** Repositorio de RegionProduct. */
  private final RegionProductRepository regionProductRepository;

  /** Repositorio de KeysProduct. */
  private final KeysProductRepository keysProductRepository;

  private final FileStorageService fileStorageService;

  private final TranslationRepository translationRepository;

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
      LanguageRepository languageRepository,
      AvailabilityRepository availabilityRepository,
      FeatureRepository featureRepository,
      NumberPlayerRepository numberPlayerRepository,
      GameFeatureRepository gameFeatureRepository,
      SagaRepository sagaRepository,
      SystemRequirementRepository systemRequirementRepository,
      ProductRepository productRepository,
      VendorProductRepository logoProductRepository,
      EditionProductRepository editionProductRepository,
      PlatformProductRepository platformProductRepository,
      RegionProductRepository regionProductRepository,
      KeysProductRepository keysProductRepository,
      GameScoreRepository gameScoreRepository,
      GamesListRepository gamesListRepository,
      NewsRepository newsRepository,
      TranslationRepository translationRepository,
      FileStorageService fileStorageService) {
    this.gameRepository = gameRepository;
    this.platformRepository = platformRepository;
    this.crossplayRepository = crossplayRepository;
    this.genreRepository = genreRepository;
    this.developerRepository = developerRepository;
    this.distributorRepository = distributorRepository;
    this.languageRepository = languageRepository;
    this.availabilityRepository = availabilityRepository;
    this.featureRepository = featureRepository;
    this.numberPlayerRepository = numberPlayerRepository;
    this.gameFeatureRepository = gameFeatureRepository;
    this.sagaRepository = sagaRepository;
    this.systemRequirementRepository = systemRequirementRepository;
    this.productRepository = productRepository;
    this.vendorProductRepository = logoProductRepository;
    this.editionProductRepository = editionProductRepository;
    this.platformProductRepository = platformProductRepository;
    this.regionProductRepository = regionProductRepository;
    this.keysProductRepository = keysProductRepository;
    this.gameScoreRepository = gameScoreRepository;
    this.gamesListRepository = gamesListRepository;
    this.newsRepository = newsRepository;
    this.fileStorageService = fileStorageService;
    this.translationRepository = translationRepository;
  }

  @Override
  public GameAndSagaDTO findById(Long id, Long translationId) {
    LOG.info("Finding game by id: {} with translation id: {}", id, translationId);
    Game game = gameRepository.findByIdAndTranslationId(id, translationId);
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
  public GameAndSagaDTO save(GameRequest gameRequest, MultipartFile file, Long translationId) {
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

    String fileDownloadUri = fileStorageService.storeFileAndGenerateUri(file);
    game.setCover(fileDownloadUri);

    // Si se proporcionó un ID de traducción, obtén la traducción y asígnala al juego
    Translation translation = translationRepository.findById(translationId).orElse(null);
    if (translation == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La traducción no existe");
    }
    game.setTranslation(translation);

    Game savedGame = gameRepository.save(game);

    savedGame.setProducts(createProducts(gameRequest.getProducts(), savedGame));

    return convertToGameAndSagaDTO(savedGame);
  }

  @Override
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

  @Override
  public <T> List<T> validateAndGetEntities(
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

  @Override
  public Saga getOrCreateSaga(Saga saga) {
    if (saga == null) {
      return null;
    }

    if (saga.getId() != null) {
      Optional<Saga> existingSaga = sagaRepository.findById(saga.getId());
      if (existingSaga.isPresent()) {
        return existingSaga.get();
      } else {
        throw new IllegalArgumentException(
            "No existe una saga con el ID proporcionado. Por favor, proporciona un ID válido.");
      }
    } else {
      Saga newSaga = new Saga();
      newSaga.setName(saga.getName());
      return sagaRepository.save(newSaga);
    }
  }

  @Override
  public List<Availability> createAvailabilities(
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

  @Override
  public List<GameFeature> createGameFeatures(List<GameFeatureRequest> gameFeatureRequests) {
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
        if (feature.getName().toLowerCase().equals("coop.online")
            || feature.getName().toLowerCase().equals("coop.lan")) {
          numberPlayer =
              numberPlayerRepository
                  .findById(gameFeatureRequest.getNumberPlayerId())
                  .orElseThrow(
                      () ->
                          new IllegalArgumentException(
                              "NumberPlayer no encontrado con id: "
                                  + gameFeatureRequest.getNumberPlayerId()));
        } else {
          throw new IllegalArgumentException(
              "No se puede asignar NumberPlayer a la característica: " + feature.getName());
        }
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

  @Override
  public List<Product> createProducts(List<ProductRequest> productRequests, Game game) {
    if (productRequests == null || productRequests.isEmpty()) {
      throw new IllegalArgumentException("La lista de productos no puede ser nula ni vacía");
    }
    List<Product> savedProducts = new ArrayList<>();
    for (ProductRequest productRequest : productRequests) {
      Product product = new Product();
      product.setGame(game); // Asociar el producto con el juego
      product.setPrice(productRequest.getPrice());
      product.setLink(productRequest.getLink());
      product.setVendorProduct(
          vendorProductRepository.findById(productRequest.getLogoProductId()).orElse(null));
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

  @Override
  public ScoreAverageResultDTO calculateAverageScore(Long gameId) {
    return gameRepository.findAverageScoreAndCount(gameId);
  }

  @Override
  public List<ScoreAverageResultDTO> calculateAverageScoreOfLast100(Long gameId) {
    Pageable topHundred = PageRequest.of(0, 100, Sort.by(Sort.Direction.DESC, "date"));
    return gameRepository.findAverageScoreAndCountForGame(gameId, topHundred);
  }

  @Override
  public List<GamePopularityProjection> findTop5ByDateAfterAndOrderByPopularityDesc(
      Long translationId) {
    LOG.info("Finding top 5 popular unreleased games");
    return gameRepository.findTop5ByDateAfterAndOrderByPopularityDesc(
        LocalDate.now(), translationId, PageRequest.of(0, 5));
  }

  @Override
  public List<GamePopularityProjection> findByDateAfterAndOrderByPopularityDesc(
      Long translationId) {
    LOG.info("Finding all popular unreleased games");
    return gameRepository.findByDateAfterAndOrderByPopularityDesc(LocalDate.now(), translationId);
  }

  @Override
  public List<GamePopularityProjection> getFiveGamesByDate(Long translationId) {
    return gameRepository.findTop5ByOrderByDateDesc(translationId, PageRequest.of(0, 5));
  }

  @Override
  public List<GameSearchDTO> searchGames(String keyword, Long translationId) {
    List<Game> games = gameRepository.search(keyword, translationId, Pageable.unpaged());
    return games.stream()
        .map(
            game -> {
              GameSearchDTO dto = new GameSearchDTO();
              dto.setId(game.getId());
              dto.setTitle(game.getTitle());
              dto.setCover(game.getCover());
              dto.setAlt(game.getAlt());
              dto.setDate(game.getDate());
              String developers =
                  game.getDevelopers().stream()
                      .map(Developer::getName)
                      .collect(Collectors.joining(", "));
              dto.setDeveloper(developers);
              dto.setScore(calculateAverageScore(game.getId()).getAverageScore());
              return dto;
            })
        .collect(Collectors.toList());
  }

  @Override
  public List<GameSearchDTO> searchTop5Games(String keyword, Long translationId) {
    List<Game> games = gameRepository.search(keyword, translationId, PageRequest.of(0, 5));
    return games.stream()
        .map(
            game -> {
              GameSearchDTO dto = new GameSearchDTO();
              dto.setId(game.getId());
              dto.setTitle(game.getTitle());
              dto.setCover(game.getCover());
              dto.setAlt(game.getAlt());
              dto.setDate(game.getDate());
              String developers =
                  game.getDevelopers().stream()
                      .map(Developer::getName)
                      .collect(Collectors.joining(", "));
              dto.setDeveloper(developers);
              dto.setScore(calculateAverageScore(game.getId()).getAverageScore());
              return dto;
            })
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Long id) {
    LOG.info("Deleting game by id: {}", id);

    // Elimina todos los GameScore asociados

    gameScoreRepository.deleteByGameId(id);

    gamesListRepository.deleteAssociationsByGameId(id);
    newsRepository.setGameIdToNullByGameId(id);

    // Ahora puedes eliminar el Game
    gameRepository.deleteById(id);
  }

  @Override
  public Page<GameAdminDTO> findAllGames(Pageable pageable) {
    return gameRepository.findAllGames(pageable);
  }

  @Override
  public GameAndSagaDTO updateGame(
      Long id, GameRequest gameRequest, MultipartFile file, Long translationId) {
    LOG.info("Updating game with id: {}", id);
    Game game =
        gameRepository
            .findById(id)
            .orElseThrow(() -> new RuntimeException("Game not found with id: " + id));

    updateGameFromRequest(game, gameRequest, file);

    if (gameRequest.getMinimumSystemRequirement() != null) {
      game.setMinimumSystemRequirement(
          updateSystemRequirement(
              game.getMinimumSystemRequirement(), gameRequest.getMinimumSystemRequirement()));
    }
    if (gameRequest.getRecommendedSystemRequirement() != null) {
      game.setRecommendedSystemRequirement(
          updateSystemRequirement(
              game.getRecommendedSystemRequirement(),
              gameRequest.getRecommendedSystemRequirement()));
    }

    if (gameRequest.getPlatformIds() != null) {
      List<Platform> platforms =
          validateAndGetEntities(gameRequest.getPlatformIds(), platformRepository, "plataformas");
      game.setPlatforms(platforms);
    }

    if (gameRequest.getGenreIds() != null) {
      List<Genre> genres =
          validateAndGetEntities(gameRequest.getGenreIds(), genreRepository, "géneros");
      game.setGenres(genres);
    }
    if (gameRequest.getDeveloperIds() != null) {
      List<Developer> developers =
          validateAndGetEntities(
              gameRequest.getDeveloperIds(), developerRepository, "desarrolladores");
      game.setDevelopers(developers);
    }

    if (gameRequest.getDistributorIds() != null) {
      List<Distributor> distributors =
          validateAndGetEntities(
              gameRequest.getDistributorIds(), distributorRepository, "distribuidores");
      game.setDistributors(distributors);
    }

    if (gameRequest.getCrossplayId() != null) {
      Crossplay existingCrossplay =
          crossplayRepository
              .findById(gameRequest.getCrossplayId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "Crossplay no encontrado con id: " + gameRequest.getCrossplayId()));
      game.setCrossplay(existingCrossplay);
    }

    if (gameRequest.getAvailabilities() != null) {
      List<Availability> newAvailabilities = new ArrayList<>();
      for (AvailabilityRequest availabilityRequest : gameRequest.getAvailabilities()) {
        newAvailabilities.add(updateAvailability(game, availabilityRequest));
      }
      // Añade las nuevas disponibilidades a la lista del juego
      game.getAvailabilities().addAll(newAvailabilities);
    }

    if (gameRequest.getGameFeatures() != null) {
      List<GameFeature> newGameFeatures = new ArrayList<>();
      for (GameFeatureRequest gameFeatureRequest : gameRequest.getGameFeatures()) {
        newGameFeatures.add(updateGameFeature(game, gameFeatureRequest));
      }
      // Añade las nuevas características a la lista del juego
      game.getGameFeatures().addAll(newGameFeatures);
    }

    if (gameRequest.getSaga() != null) {

      game.setSaga(getOrCreateSaga(gameRequest.getSaga()));
    }

    if (gameRequest.getProducts() != null) {
      List<Product> newProducts = new ArrayList<>();
      for (ProductRequest productRequest : gameRequest.getProducts()) {
        newProducts.add(updateProduct(game, productRequest));
      }
      // Añade los nuevos productos a la lista del juego
      game.getProducts().addAll(newProducts);
    }

    if (translationId != null) {
      Translation translation = translationRepository.findById(translationId).orElse(null);
      if (translation == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La traducción no existe");
      }
      game.setTranslation(translation);
    }

    Game savedGame = gameRepository.save(game);
    return convertToGameAndSagaDTO(savedGame);
  }

  @Override
  public void updateGameFromRequest(Game game, GameRequest gameRequest, MultipartFile file) {
    if (Objects.nonNull(gameRequest.getGame().getTitle())) {
      game.setTitle(gameRequest.getGame().getTitle());
    }
    if (file != null && !file.isEmpty()) {
      String fileDownloadUri = fileStorageService.replaceFileAndGenerateUri(file, game.getCover());
      game.setCover(fileDownloadUri);
    }
    if (Objects.nonNull(gameRequest.getGame().getAlt())) {
      game.setAlt(gameRequest.getGame().getAlt());
    }
    if (Objects.nonNull(gameRequest.getGame().getDate())) {
      game.setDate(gameRequest.getGame().getDate());
    }
    if (Objects.nonNull(gameRequest.getGame().getTrailer())) {
      game.setTrailer(gameRequest.getGame().getTrailer());
    }
    if (Objects.nonNull(gameRequest.getGame().getSinopsis())) {
      game.setSinopsis(gameRequest.getGame().getSinopsis());
    }
    if (Objects.nonNull(gameRequest.getGame().getStoryTime())) {
      game.setStoryTime(gameRequest.getGame().getStoryTime());
    }
    if (Objects.nonNull(gameRequest.getGame().getCompleteTime())) {
      game.setCompleteTime(gameRequest.getGame().getCompleteTime());
    }
  }

  @Override
  public SystemRequirement updateSystemRequirement(
      SystemRequirement existingReq, SystemRequirement newReq) {
    if (newReq.getOperatingSystem() != null) {
      existingReq.setOperatingSystem(newReq.getOperatingSystem());
    }
    if (newReq.getProcessor() != null) {
      existingReq.setProcessor(newReq.getProcessor());
    }
    if (newReq.getRam() != null) {
      existingReq.setRam(newReq.getRam());
    }
    if (newReq.getGraphicsCard() != null) {
      existingReq.setGraphicsCard(newReq.getGraphicsCard());
    }
    if (newReq.getDirectX() != null) {
      existingReq.setDirectX(newReq.getDirectX());
    }
    if (newReq.getStorage() != null) {
      existingReq.setStorage(newReq.getStorage());
    }
    return systemRequirementRepository.save(existingReq);
  }

  @Override
  public Availability updateAvailability(Game game, AvailabilityRequest availabilityRequest) {
    Availability availability;
    if (availabilityRequest.getId() != null) {
      availability =
          availabilityRepository
              .findById(availabilityRequest.getId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "Disponibilidad no encontrada con id: " + availabilityRequest.getId()));
      if (!game.getAvailabilities().contains(availability)) {
        throw new IllegalArgumentException(
            "La Availability con id: " + availabilityRequest.getId() + " no pertenece al juego");
      }
      // Elimina la disponibilidad antigua de la lista del juego
      game.getAvailabilities().remove(availability);
    } else {
      availability = new Availability();
    }
    // Se establecen los idiomas de la interfaz, los subtítulos y el audio
    availability.setInterfaceLanguage(availabilityRequest.getInterfaceLanguage());
    availability.setSubtitleLanguage(availabilityRequest.getSubtitleLanguage());
    availability.setAudioLanguage(availabilityRequest.getAudioLanguage());
    // Se establece el idioma
    availability.setLanguage(
        languageRepository
            .findById(availabilityRequest.getLanguageId())
            .orElseThrow(
                () ->
                    new IllegalArgumentException(
                        "Idioma no encontrado con id: " + availabilityRequest.getLanguageId())));
    // Se establece el juego
    availability.setGame(game);
    // Se guarda la disponibilidad en el repositorio y se añade a la lista de nuevas
    // disponibilidades
    return availabilityRepository.save(availability);
  }

  @Override
  public GameFeature updateGameFeature(Game game, GameFeatureRequest gameFeatureRequest) {
    GameFeature gameFeature;
    if (gameFeatureRequest.getId() != null) {
      gameFeature =
          gameFeatureRepository
              .findById(gameFeatureRequest.getId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "GameFeature no encontrada con id: " + gameFeatureRequest.getId()));
      if (!game.getGameFeatures().contains(gameFeature)) {
        throw new IllegalArgumentException(
            "La GameFeature con id: " + gameFeatureRequest.getId() + " no pertenece al juego");
      }
      // Elimina la característica antigua de la lista del juego
      game.getGameFeatures().remove(gameFeature);
    } else {
      gameFeature = new GameFeature();
    }
    // Establece los campos de gameFeature...
    Feature feature =
        featureRepository
            .findById(gameFeatureRequest.getFeatureId())
            .orElseThrow(
                () ->
                    new IllegalArgumentException(
                        "Feature no encontrada con id: " + gameFeatureRequest.getFeatureId()));
    gameFeature.setFeature(feature); // Aquí se actualiza el featureId
    if (gameFeatureRequest.getNumberPlayerId() != null) {
      NumberPlayer numberPlayer =
          numberPlayerRepository
              .findById(gameFeatureRequest.getNumberPlayerId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "NumberPlayer no encontrado con id: "
                              + gameFeatureRequest.getNumberPlayerId()));
      gameFeature.setNumberPlayers(numberPlayer);
    } else {
      gameFeature.setNumberPlayers(null);
    }
    return gameFeatureRepository.save(gameFeature);
  }

  @Override
  public Product updateProduct(Game game, ProductRequest productRequest) {
    Product product;
    if (productRequest.getId() != null) {
      product =
          productRepository
              .findById(productRequest.getId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "Product no encontrado con id: " + productRequest.getId()));
      if (!game.getProducts().contains(product)) {
        throw new IllegalArgumentException(
            "El Product con id: " + productRequest.getId() + " no pertenece al juego");
      }
    } else {
      product = new Product();
    }
    product.setGame(game); // Asociar el producto con el juego
    if (productRequest.getPrice() != null) {
      product.setPrice(productRequest.getPrice());
    }
    if (productRequest.getLink() != null) {
      product.setLink(productRequest.getLink());
    }
    if (productRequest.getLogoProductId() != null) {
      product.setVendorProduct(
          vendorProductRepository
              .findById(productRequest.getLogoProductId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "LogoProduct no encontrado con id: "
                              + productRequest.getLogoProductId())));
    }
    if (productRequest.getEditionProductId() != null) {
      product.setEditionProduct(
          editionProductRepository
              .findById(productRequest.getEditionProductId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "EditionProduct no encontrado con id: "
                              + productRequest.getEditionProductId())));
    }
    if (productRequest.getPlatformProductId() != null) {
      product.setPlatformProduct(
          platformProductRepository
              .findById(productRequest.getPlatformProductId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "PlatformProduct no encontrado con id: "
                              + productRequest.getPlatformProductId())));
    }
    if (productRequest.getVendorProductId() != null) {
      product.setVendorProduct(
          vendorProductRepository
              .findById(productRequest.getVendorProductId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "VendorProduct no encontrado con id: "
                              + productRequest.getVendorProductId())));
    }
    if (productRequest.getRegionProductId() != null) {
      product.setRegionProduct(
          regionProductRepository
              .findById(productRequest.getRegionProductId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "RegionProduct no encontrado con id: "
                              + productRequest.getRegionProductId())));
    }
    if (productRequest.getKeysProductId() != null) {
      product.setKeysProduct(
          keysProductRepository
              .findById(productRequest.getKeysProductId())
              .orElseThrow(
                  () ->
                      new IllegalArgumentException(
                          "KeysProduct no encontrado con id: "
                              + productRequest.getKeysProductId())));
    }
    return productRepository.save(product);
  }

  public Page<GameSearchAdminDTO> searchGames(
      String keyword, Long translationId, Pageable pageable) {
    return gameRepository.searchGames(keyword, translationId, pageable);
  }
}
