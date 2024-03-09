package com.winningstation.controller;

import com.winningstation.entity.GameScore;
import com.winningstation.services.interfaces.IGameScoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador que permite realizar operaciones sobre la puntuación de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Game Score Controller", description = "Operaciones para la puntuación de los juegos")
@RestController
@RequestMapping("/game-score")
public class GameScoreController {

  /** Servicio para la puntuación de los juegos. */
  private final IGameScoreService gameScoreService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param gameScoreService Servicio para la puntuación de los juegos.
   */
  public GameScoreController(IGameScoreService gameScoreService) {
    this.gameScoreService = gameScoreService;
  }

  /**
   * Guarda una nueva puntuación de un juego.
   *
   * @param userId Id del usuario que puntuó el juego.
   * @param gameId Id del juego que fue puntuado.
   * @param score Puntuación que el usuario le dio al juego.
   * @return Puntuación guardada.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @PostMapping("/user/{userId}/game/{gameId}/score/{score}")
  @Operation(
      summary = "Guarda una nueva puntuación de un juego",
      description =
          "Guarda una nueva puntuación de un juego basada en los identificadores de usuario y juego proporcionados y la puntuación, y devuelve la puntuación guardada")
  public GameScore saveGameScore(
      @PathVariable Long userId, @PathVariable Long gameId, @PathVariable int score) {
    return gameScoreService.createOrUpdateGameScore(userId, gameId, score);
  }

  /**
   * Obtiene la puntuación que le dio un usuario a un juego.
   *
   * @param userId Id del usuario que puntuó el juego.
   * @param gameId Id del juego que fue puntuado.
   * @return La puntuación del juego obtenida.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @GetMapping("/user/{userId}/game/{gameId}")
  @Operation(
      summary = "Obtiene la puntuación que le dio un usuario a un juego",
      description =
          "Obtiene la puntuación que le dio un usuario a un juego basada en los identificadores de usuario y juego proporcionados")
  public ResponseEntity<GameScore> findGameScoreByUserIdAndGameId(
      @PathVariable Long userId, @PathVariable Long gameId) {
    GameScore gameScore = gameScoreService.findGameScoreByUserIdAndGameId(userId, gameId);
    if (gameScore == null) {
      // Devuelve un ResponseEntity con código de estado 404
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(gameScore, HttpStatus.OK);
  }
}
