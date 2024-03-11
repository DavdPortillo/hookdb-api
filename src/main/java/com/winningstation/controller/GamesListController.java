package com.winningstation.controller;

import com.winningstation.dto.GameListDTO;
import com.winningstation.dto.ListDTO;
import com.winningstation.dto.ListDTOGame;
import com.winningstation.entity.GamesList;
import com.winningstation.services.interfaces.IGamesListService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para la lista de juegos.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Games List Controller", description = "Operaciones para la lista de juegos")
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
  @PreAuthorize("#idUser == authentication.principal.id")
  @PostMapping("/user/{idUser}")
  @Operation(
      summary = "Guarda una nueva lista de juegos",
      description =
          "Guarda una nueva lista de juegos basada en la petición proporcionada y devuelve la lista de juegos guardada")
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
  @PreAuthorize("#idUser == authentication.principal.id")
  @PostMapping("/list/{idList}/user/{idUser}/game/{idGame}")
  @Operation(
      summary = "Añade un juego a la lista de juegos",
      description =
          "Añade un juego a la lista de juegos basado en los identificadores de lista, usuario y juego proporcionados y devuelve la lista de juegos actualizada")
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
  @PreAuthorize("#idUser == authentication.principal.id")
  @GetMapping("/userId/{idUser}/list/{gamesListId}/games")
  @Operation(
      summary = "Encuentra los juegos de una lista",
      description =
          "Devuelve los juegos de una lista basada en el identificador de lista proporcionado")
  public ResponseEntity<List<GameListDTO>> getGamesListGames(
      @PathVariable Long idUser, @PathVariable Long gamesListId) {
    List<GameListDTO> gameResponses = gamesListService.getGamesByList(idUser, gamesListId);
    return new ResponseEntity<>(gameResponses, HttpStatus.OK);
  }

  /**
   * Elimina un juego de la lista de juegos.
   *
   * @param idList Id de la lista de juegos.
   * @param idGame Id del juego a eliminar.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @DeleteMapping("userId/{userId}/listId/{idList}/game/{idGame}")
  @Operation(
      summary = "Elimina un juego de la lista de juegos",
      description =
          "Elimina un juego de la lista de juegos basado en los identificadores de lista y juego proporcionados")
  public void deleteGameFromList(
      @PathVariable Long userId, @PathVariable Long idList, @PathVariable Long idGame) {
    gamesListService.deleteGameFromList(userId, idList, idGame);
  }

  /**
   * Encuentra las listas de juegos de un usuario.
   *
   * @param userId Id del usuario.
   * @return Lista de juegos guardada.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @GetMapping("/user/{userId}/lists")
  @Operation(
      summary = "Encuentra las listas de juegos de un usuario",
      description =
          "Devuelve las listas de juegos de un usuario basado en el identificador de usuario proporcionado")
  public List<ListDTO> findListByUserId(@PathVariable Long userId) {
    return gamesListService.findListByUserId(userId);
  }

  /**
   * Encuentra las listas y si un juego está en ellas.
   *
   * @param userId Id del usuario.
   * @param gameId Id del juego.
   * @return Lista de juegos guardada.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @GetMapping("/user/{userId}/game/{gameId}/lists")
  @Operation(
      summary = "Encuentra las listas de juegos de un usuario y si un juego está en ellas",
      description =
          "Devuelve las listas de juegos de un usuario basado en el identificador de usuario proporcionado")
  public List<ListDTOGame> findListByUserIdAndGameId(
      @PathVariable Long userId, @PathVariable Long gameId) {
    return gamesListService.findListByUserIdAndGameId(userId, gameId);
  }

  /**
   * Elimina una lista de juegos.
   *
   * @param idList Id de la lista de juegos.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @DeleteMapping("/userId/{userId}/listId/{idList}")
  @Operation(
      summary = "Elimina una lista de juegos",
      description = "Elimina una lista de juegos basada en el identificador de lista proporcionado")
  public void deleteList(@PathVariable Long userId, @PathVariable Long idList) {
    gamesListService.deleteList(userId, idList);
  }

  /**
   * Actualiza una lista de juegos.
   *
   * @param id Id de la lista de juegos.
   * @param newName Nuevo nombre de la lista de juegos.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @PutMapping("/userId/{userId}/listId/{id}")
  @Operation(
      summary = "Actualiza una lista de juegos",
      description =
          "Actualiza una lista de juegos basada en el identificador y el nuevo nombre proporcionados y devuelve el nombre actualizado")
  public ResponseEntity<String> updateGamesListName(
      @PathVariable Long userId, @PathVariable Long id, @RequestBody String newName) {
    String updatedName = gamesListService.updateGamesListName(userId, id, newName);
    return ResponseEntity.ok(updatedName);
  }

  /**
   * Encuentra las listas de juegos de un usuario por un patrón de nombre.
   *
   * @param userId Id del usuario.
   * @param namePattern Patrón de nombre.
   * @return Lista de juegos guardada.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @GetMapping("/user/{userId}/lists/{namePattern}")
  @Operation(
      summary = "Encuentra las listas de juegos de un usuario por un patrón de nombre",
      description =
          "Devuelve las listas de juegos de un usuario que coinciden con un patrón de nombre basado en el identificador de usuario y el patrón de nombre proporcionados")
  public List<ListDTO> findListByUserIdAndNamePattern(
      @PathVariable Long userId, @PathVariable String namePattern) {
    return gamesListService.findListByUserIdAndNamePattern(userId, namePattern);
  }
}
