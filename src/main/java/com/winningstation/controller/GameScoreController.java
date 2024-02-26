package com.winningstation.controller;

import com.winningstation.entity.GameScore;
import com.winningstation.services.interfaces.IGameScoreService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador que permite realizar operaciones sobre la puntuación de los juegos.
 *
 * @author David Portillo Hoyos
 */
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
  @PostMapping("/user/{userId}/game/{gameId}/score/{score}")
  public GameScore saveGameScore(
      @PathVariable Long userId, @PathVariable Long gameId, @PathVariable int score) {
    return gameScoreService.createOrUpdateGameScore(userId, gameId, score);
  }
}
