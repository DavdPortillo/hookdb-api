package com.winningstation.services.interfaces;

import com.winningstation.dto.GameListDTO;
import com.winningstation.dto.ListDTO;
import com.winningstation.dto.ListDTOGame;
import com.winningstation.entity.GamesList;

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

  /**
   * Encuentra los juegos de una lista de un usuario.
   *
   * @param idList Id de la lista.
   * @param idUser Id del usuario.
   * @return Lista de juegos guardada.
   */
  List<GameListDTO> getGamesByList(Long idUser, Long idList);

  List<ListDTOGame> findListByUserIdAndGameId(Long userId, Long gameId);

  /** Elimina un juego de la lista de juegos. */
  void deleteGameFromList(Long userId, Long gamesListId, Long gameId);

  /**
   * Encuentra las listas de juegos de un usuario.
   *
   * @param userId Id del usuario.
   * @return Lista de juegos guardada.
   */
  List<ListDTO> findListByUserId(Long userId);

  /**
   * Elimina una lista de juegos.
   *
   * @param idList Id de la lista de juegos.
   * @param userId Id del usuario.
   */
  void deleteList(Long userId, Long idList);

  /**
   * Edita el nombre de una lista de juegos.
   *
   * @param idList Id de la lista de juegos.
   * @param userId Id del usuario.
   * @param newName Nuevo nombre de la lista de juegos.
   * @return Nombre de la lista de juegos actualizado.
   */
  String updateGamesListName(Long userId, Long idList, String newName);

  /**
   * Encuentra las listas de juegos de un usuario por un patrón de nombre.
   *
   * @param userId Id del usuario.
   * @param namePattern Patrón de nombre.
   * @return Lista de juegos guardada.
   */
  List<ListDTO> findListByUserIdAndNamePattern(Long userId, String namePattern);
}
