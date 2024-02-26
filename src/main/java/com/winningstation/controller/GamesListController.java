package com.winningstation.controller;

import com.winningstation.entity.GamesList;
import com.winningstation.services.interfaces.IGamesListService;
import org.springframework.web.bind.annotation.*;

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
}
