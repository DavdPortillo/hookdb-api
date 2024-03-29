package com.winningstation.controller;

import com.winningstation.dto.*;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.projection.GamePopularityProjection;
import com.winningstation.request.GameRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.winningstation.entity.Game;
import com.winningstation.services.interfaces.IGameService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controlador para el juego.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/game")
@Tag(name = "Game Controller", description = "Controlador para gestionar los juegos")
public class GameController {

  /** Servicio para los juegos. */
  private final IGameService gameService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param gameService Servicio para los juegos.
   */
  public GameController(IGameService gameService) {
    this.gameService = gameService;
  }

  /**
   * Crea un nuevo juego.
   *
   * @param gameRequest La petición para guardar un juego.
   * @return El juego creado.
   */
  @PostMapping("/language/{translationId}")
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Crea un nuevo juego",
      description =
          "Crea un nuevo juego basado en la petición proporcionada y devuelve el juego creado")
  public GameAndSagaDTO createGame(
      @ModelAttribute GameRequest gameRequest,
      @RequestPart("file") MultipartFile file,
      @PathVariable Long translationId) {
    Game game = gameRequest.getGame();
    if (game == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El objeto Game no puede ser null");
    }
    return gameService.save(gameRequest, file, translationId);
  }

  /**
   * Encuentra todos los juegos.
   *
   * @return Lista de juegos.
   */
  @GetMapping("/all")
  @Operation(
      summary = "Obtiene todos los juegos",
      description = "Devuelve una lista de todos los juegos")
  public ResponseEntity<Page<GameAdminDTO>> getAllGames(Pageable pageable) {
    return ResponseEntity.ok(gameService.findAllGames(pageable));
  }

  /**
   * Encuentra un juego por su ID.
   *
   * @param id Id del juego.
   * @return El juego encontrado.
   */
  @GetMapping("/{id}/language/{translationId}")
  @Operation(
      summary = "Obtiene un juego por su ID",
      description = "Devuelve un juego basado en su ID")
  public ResponseEntity<GameAndSagaDTO> getGame(
      @PathVariable Long id, @PathVariable Long translationId) {
    GameAndSagaDTO game = gameService.findById(id, translationId);
    if (game == null) {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(game, HttpStatus.OK);
  }

  /**
   * Encuentra el promedio de puntuación de un juego.
   *
   * @param gameId Id del juego.
   * @return El promedio de puntuación del juego.
   */
  @GetMapping("/average-score/{gameId}")
  @Operation(
      summary = "Obtiene el promedio de puntuación de un juego",
      description = "Devuelve el promedio de puntuación de un juego basado en su ID")
  public ScoreAverageResultDTO getAverageScore(@PathVariable Long gameId) {
    return gameService.calculateAverageScore(gameId);
  }

  /**
   * Encuentra el promedio de los últimos 100 puntajes de un juego.
   *
   * @param gameId Id del juego.
   * @return El promedio de los últimos 100 puntajes del juego.
   */
  @GetMapping("/average-score-last-100/id-game/{gameId}")
  @Operation(
      summary = "Obtiene el promedio de los últimos 100 puntajes de un juego",
      description = "Devuelve el promedio de los últimos 100 puntajes de un juego basado en su ID")
  public List<ScoreAverageResultDTO> getAverageScoreOfLast100(@PathVariable Long gameId) {
    return gameService.calculateAverageScoreOfLast100(gameId);
  }

  /**
   * Encuentra los 5 juegos más populares.
   *
   * @return Lista de los 5 juegos más populares
   */
  @GetMapping("/top-5-popular/language/{translationId}")
  @Operation(
      summary = "Obtiene los 5 juegos más populares",
      description = "Devuelve una lista de los 5 juegos más populares")
  public List<GamePopularityProjection> getTop5Popular(@PathVariable Long translationId) {
    return gameService.findTop5ByDateAfterAndOrderByPopularityDesc(translationId);
  }

  /**
   * Encuentra los juegos más populares.
   *
   * @return Lista de los juegos más populares
   */
  @GetMapping("/popular/language/{translationId}")
  @Operation(
      summary = "Obtiene los juegos más populares",
      description = "Devuelve una lista de los juegos más populares")
  public List<GamePopularityProjection> getPopular(@PathVariable Long translationId) {
    return gameService.findByDateAfterAndOrderByPopularityDesc(translationId);
  }

  /**
   * Encuentra los juegos
   *
   * @return Lista de los juegos más populares
   */
  @GetMapping("/name/{keyword}/language/{translationId}")
  @Operation(
      summary = "Busca juegos por palabra clave",
      description = "Devuelve una lista de juegos que coinciden con la palabra clave proporcionada")
  public ResponseEntity<List<GameSearchDTO>> searchGames(
      @PathVariable String keyword, @PathVariable Long translationId) {
    List<GameSearchDTO> games = gameService.searchGames(keyword, translationId);
    return new ResponseEntity<>(games, HttpStatus.OK);
  }

  /**
   * Encuentra los 5 juegos dependiendo de la keyword y la popularidad.
   *
   * @return Lista de los juegos más populares
   */
  @GetMapping("/search-five-suggestions/{keyword}/language/{translationId}")
  @Operation(
      summary = "Busca los 5 juegos más populares por palabra clave",
      description =
          "Devuelve una lista de los 5 juegos más populares que coinciden con la palabra clave proporcionada")
  public ResponseEntity<List<GameSearchDTO>> searchTop5Games(
      @PathVariable String keyword, @PathVariable Long translationId) {
    List<GameSearchDTO> games = gameService.searchTop5Games(keyword, translationId);
    return new ResponseEntity<>(games, HttpStatus.OK);
  }

  /**
   * Actualiza un juego.
   *
   * @param gameRequest La petición para actualizar un juego.
   * @return El juego actualizado.
   */
  @PutMapping("/{id}/language/{translationId}")
  @Operation(
      summary = "Actualiza un juego",
      description =
          "Actualiza un juego basado en la petición proporcionada y devuelve el juego actualizado")
  public GameAndSagaDTO updateGame(
      @PathVariable Long id,
      @ModelAttribute GameRequest gameRequest,
      @RequestPart(value = "file", required = false) MultipartFile file,
      @PathVariable Long translationId) {
    Game game = gameRequest.getGame();
    if (game == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El objeto Game no puede ser null");
    }
    return gameService.updateGame(id, gameRequest, file, translationId);
  }

  @GetMapping("/topByDate/{translationId}")
    @Operation(
        summary = "Obtiene los 5 juegos más populares por fecha",
        description = "Devuelve una lista de los 5 juegos más populares por fecha")
  public List<GamePopularityProjection> getTop5Games(@PathVariable Long translationId) {
    return gameService.getFiveGamesByDate(translationId);
  }

  @DeleteMapping("/{id}")
  @Operation(summary = "Elimina un juego", description = "Elimina un juego basado en su ID")
  public void deleteGame(@PathVariable Long id) {
    gameService.delete(id);
  }

  @Operation(
      summary = "Obtiene todos los juegos",
      description = "Devuelve una lista de todos los juegos")
  @GetMapping("/search/{keyword}/{translationId}")
  public ResponseEntity<Page<GameSearchAdminDTO>> searchGames(
      @PathVariable("keyword") String keyword,
      @PathVariable("translationId") Long translationId,
      Pageable pageable) {
    Page<GameSearchAdminDTO> games = gameService.searchGames(keyword, translationId, pageable);
    return new ResponseEntity<>(games, HttpStatus.OK);
  }
}
