package com.winningstation.controller;

import com.winningstation.dto.GameAndSagaDTO;
import com.winningstation.dto.GameSearchDTO;
import com.winningstation.dto.ScoreAverageResultDTO;
import com.winningstation.projection.GamePopularityProjection;
import com.winningstation.request.GameRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.winningstation.entity.Game;
import com.winningstation.services.interfaces.IGameService;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controlador para el juego.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/game")
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
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public GameAndSagaDTO createGame(@RequestBody GameRequest gameRequest) {
    Game game = gameRequest.getGame();
    if (game == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El objeto Game no puede ser null");
    }
    return gameService.save(gameRequest);
  }

  /**
   * Encuentra todos los juegos.
   *
   * @return Lista de juegos.
   */
  @GetMapping
  public Iterable<Game> findAll() {
    return gameService.findAll();
  }

  /**
   * Encuentra un juego por su id.
   *
   * @param id Id del juego a buscar.
   * @return El juego encontrado.
   */
  @GetMapping("/{id}")
  public ResponseEntity<GameAndSagaDTO> getGame(@PathVariable Long id) {
    GameAndSagaDTO game = gameService.findById(id);
    return ResponseEntity.ok(game);
  }

  /**
   * Encuentra el promedio de puntuación de un juego.
   *
   * @param gameId Id del juego.
   * @return El promedio de puntuación del juego.
   */
  @GetMapping("/average-score/{gameId}")
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
  public ScoreAverageResultDTO getAverageScoreOfLast100(@PathVariable Long gameId) {
    return gameService.calculateAverageScoreOfLast100(gameId);
  }

  /**
   * Encuentra los 5 juegos más populares.
   *
   * @return Lista de los 5 juegos más populares
   */
  @GetMapping("/top-5-popular")
  public List<GamePopularityProjection> getTop5Popular() {
    return gameService.findTop5ByDateAfterAndOrderByPopularityDesc();
  }

  /**
   * Encuentra los juegos más populares.
   *
   * @return Lista de los juegos más populares
   */
  @GetMapping("/popular")
  public List<GamePopularityProjection> getPopular() {
    return gameService.findByDateAfterAndOrderByPopularityDesc();
  }

  /**
   * Encuentra los juegos
   *
   * @return Lista de los juegos más populares
   */
  @GetMapping("/search/{keyword}")
  public ResponseEntity<List<GameSearchDTO>> searchGames(@PathVariable String keyword) {
    List<GameSearchDTO> games = gameService.searchGames(keyword);
    return new ResponseEntity<>(games, HttpStatus.OK);
  }

  /**
   * Encuentra los 5 juegos dependiendo de la keyword y la popularidad.
   *
   * @return Lista de los juegos más populares
   */
  @GetMapping("/search-top-5/{keyword}")
  public ResponseEntity<List<GameSearchDTO>> searchTop5Games(@PathVariable String keyword) {
    List<GameSearchDTO> games = gameService.searchTop5Games(keyword);
    return new ResponseEntity<>(games, HttpStatus.OK);
  }

  /**
   * Actualiza un juego.
   *
   * @param gameRequest La petición para actualizar un juego.
   * @return El juego actualizado.
   */
  @PutMapping("/{id}")
  public GameAndSagaDTO updateGame(@PathVariable Long id, @RequestBody GameRequest gameRequest) {
    Game game = gameRequest.getGame();
    if (game == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El objeto Game no puede ser null");
    }
    return gameService.updateGame(id, gameRequest);
  }
}
