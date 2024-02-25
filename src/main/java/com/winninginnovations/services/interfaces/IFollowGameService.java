package com.winninginnovations.services.interfaces;

import com.winninginnovations.DTO.GameFollowDTO;

/**
 * Interfaz que define los métodos que se pueden realizar sobre el seguimiento de un juego.
 *
 * @author David Portillo Hoyos
 */
public interface IFollowGameService {

  /**
   * Método que permite seguir un juego.
   *
   * @param userId Id del usuario que sigue el juego.
   * @param gameId Id del juego que se sigue.
   * @return Objeto con la información del seguimiento.
   */
  GameFollowDTO followOrIgnoreGame(Long userId, Long gameId, Integer action);
}
