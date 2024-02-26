package com.winningstation.controller;

import com.winningstation.dto.GameAndSagaDTO;
import com.winningstation.dto.ScoreAverageResultDTO;
import com.winningstation.request.GameRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.winningstation.entity.Game;
import com.winningstation.services.interfaces.IGameService;
import org.springframework.web.server.ResponseStatusException;

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
  @GetMapping("/average-score-last-100/{gameId}")
  public ScoreAverageResultDTO getAverageScoreOfLast100(@PathVariable Long gameId) {
    return gameService.calculateAverageScoreOfLast100(gameId);
  }
}
