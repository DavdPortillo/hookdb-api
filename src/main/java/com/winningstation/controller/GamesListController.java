package com.winningstation.controller;

import com.winningstation.dto.GameListDTO;
import com.winningstation.dto.ListDTO;
import com.winningstation.entity.GamesList;
import com.winningstation.services.interfaces.IGamesListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la lista de juegos.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/gameslist")
public class GamesListController {

  /** Servicio para la lista de juegos. */
  private final IGamesListService gamesListService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param gamesListService Servicio para la lista de juegos.
   */
  public GamesListController(IGamesListService gamesListService) {
    this.gamesListService = gamesListService;
  }

  /**
   * Guarda una nueva lista de juegos.
   *
   * @param gamesList La lista de juegos a guardar.
   * @return Lista de juegos guardada.
   */
  @PostMapping("/user/{idUser}")
  public GamesList saveGamesList(@RequestBody GamesList gamesList, @PathVariable Long idUser) {
    return gamesListService.createGamesList(gamesList, idUser);
  }

  /**
   * Añade un juego a la lista de juegos.
   *
   * @param idList Id de la lista a la que se va a añadir el juego.
   * @param idUser Id del usuario que guarda la lista de juegos.
   * @param idGame Id del juego que se va a añadir a la lista.
   * @return Lista de juegos guardada.
   */
  @PostMapping("/list/{idList}/user/{idUser}/game/{idGame}")
  public GamesList addGameToList(
      @PathVariable Long idList, @PathVariable Long idUser, @PathVariable Long idGame) {
    return gamesListService.addGameToList(idList, idUser, idGame);
  }

  /**
   * Encuentra los juegos de una lista.
   *
   * @param gamesListId Id de la lista de juegos.
   * @return Lista de juegos guardada.
   */
  @GetMapping("/{gamesListId}/games")
  public ResponseEntity<List<GameListDTO>> getGamesListGames(@PathVariable Long gamesListId) {
    List<GameListDTO> gameResponses = gamesListService.getGamesByList(gamesListId);
    return new ResponseEntity<>(gameResponses, HttpStatus.OK);
  }

  /**
   * Elimina un juego de la lista de juegos.
   *
   * @param idList Id de la lista de juegos.
   * @param idGame Id del juego a eliminar.
   */
  @DeleteMapping("/{idList}/game/{idGame}")
  public void deleteGameFromList(@PathVariable Long idList, @PathVariable Long idGame) {
    gamesListService.deleteGameFromList(idList, idGame);
  }

  /**
   * Encuentra las listas de juegos de un usuario.
   *
   * @param userId Id del usuario.
   * @return Lista de juegos guardada.
   */
  @GetMapping("/user/{userId}/lists")
  public List<ListDTO> findListByUserId(@PathVariable Long userId) {
    return gamesListService.findListByUserId(userId);
  }

  /**
   * Elimina una lista de juegos.
   *
   * @param idList Id de la lista de juegos.
   */
  @DeleteMapping("/{idList}")
  public void deleteList(@PathVariable Long idList) {
    gamesListService.deleteList(idList);
  }

  /**
   * Actualiza una lista de juegos.
   *
   * @param id Id de la lista de juegos.
   * @param newName Nuevo nombre de la lista de juegos.
   */
  @PutMapping("/{id}")
  public ResponseEntity<String> updateGamesListName(
      @PathVariable Long id, @RequestBody String newName) {
    String updatedName = gamesListService.updateGamesListName(id, newName);
    return ResponseEntity.ok(updatedName);
  }

  /**
   * Encuentra las listas de juegos de un usuario por un patrón de nombre.
   *
   * @param userId Id del usuario.
   * @param namePattern Patrón de nombre.
   * @return Lista de juegos guardada.
   */
  @GetMapping("/user/{userId}/lists/{namePattern}")
  public List<ListDTO> findListByUserIdAndNamePattern(
      @PathVariable Long userId, @PathVariable String namePattern) {
    return gamesListService.findListByUserIdAndNamePattern(userId, namePattern);
  }
}
