package com.winninginnovations.controller;

import com.winninginnovations.entity.GamesList;
import com.winninginnovations.services.interfaces.IGamesListService;
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
  @PostMapping("/{idUser}")
  public GamesList saveGamesList(@RequestBody GamesList gamesList, @PathVariable Long idUser) {
    return gamesListService.createGamesList(gamesList, idUser);
  }
}
