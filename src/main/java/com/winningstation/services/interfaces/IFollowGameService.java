package com.winningstation.services.interfaces;

import com.winningstation.entity.FollowGame;

import java.util.List;

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
  FollowGame followOrIgnoreGame(Long userId, Long gameId, Integer action);

  /**
   * Método que permite obtener los juegos seguidos o ignorados por un usuario.
   *
   * @param userId Id del usuario.
   * @return Lista de juegos seguidos por el usuario.
   */
    List<FollowGame> getFollowedOrIgnoredGames(Long userId);

    /**
     * Método que permite obtener los juegos seguidos por un usuario.
     *
     * @param userId Id del usuario.
     * @return Lista de juegos seguidos por el usuario.
     */
    List<FollowGame> getFollowedGames(Long userId);

    /**
     * Método que permite obtener los juegos ignorados por un usuario.
     *
     * @param userId Id del usuario.
     * @return Lista de juegos ignorados por el usuario.
     */
    List<FollowGame> getIgnoredGames(Long userId);

}
