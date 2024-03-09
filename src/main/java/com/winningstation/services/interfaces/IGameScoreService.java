package com.winningstation.services.interfaces;

import com.winningstation.entity.GameScore;

/**
 * Interfaz que define los métodos que se pueden realizar sobre la puntuación de un juego.
 *
 * @author David Portillo Hoyos
 */
public interface IGameScoreService {

  /**
   * Método que guarda la puntuación de un juego en la base de datos.
   *
   * @param userId Id del usuario que puntuó el juego.
   * @param gameId Id del juego que fue puntuado.
   * @param score Puntuación que el usuario le da al juego.
   * @return Puntuación guardada.
   */
  GameScore createOrUpdateGameScore(Long userId, Long gameId, int score);

  /**
   * Método que permite obtener la puntuación que le dio un usuario a un juego.
   *
   * @param userId Id del usuario que puntuó el juego.
   * @param gameId Id del juego que fue puntuado.
   * @return La puntuación del juego obtenida.
   */
    GameScore findGameScoreByUserIdAndGameId(Long userId, Long gameId);
}
