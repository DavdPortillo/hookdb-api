package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.GamesList;

import java.util.List;

/**
 * Interfaz que define los métodos que se pueden realizar sobre la lista de juegos.
 *
 * @author David Portillo Hoyos
 */
public interface IGamesListService {

  /**
   * Método que guarda la lista de juegos en la base de datos.
   *
   * @param gamesList Lista de juegos a guardar.
   * @param idUser Id del usuario que guarda la lista de juegos.
   * @return Lista de juegos guardada.
   */
  GamesList createGamesList(GamesList gamesList, Long idUser);

  /**
   * Añade un juego a la lista de juegos.
   *
   * @param idList Id de la lista a la que se va a añadir el juego.
   * @param idUser Id del usuario que guarda la lista de juegos.
   * @param idGame Id del juego que se va a añadir a la lista.
   * @return Lista de juegos guardada.
   */
  GamesList addGameToList(Long idList, Long idUser, Long idGame);
}
