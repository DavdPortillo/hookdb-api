package com.winninginnovations.controller;

import com.winninginnovations.dto.GameFollowDTO;
import com.winninginnovations.services.interfaces.IFollowGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para el seguimiento de juegos.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/follow-game")
public class FollowGameController {

  /** Servicio para el seguimiento de juegos. */
  private final IFollowGameService followGameService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param followGameService Servicio para el seguimiento de juegos.
   */
  public FollowGameController(IFollowGameService followGameService) {
    this.followGameService = followGameService;
  }

  @PostMapping("/users/{userId}/games/{gameId}/followOrIgnore/{action}")
  public ResponseEntity<GameFollowDTO> followOrIgnoreGame(@PathVariable Long userId, @PathVariable Long gameId, @PathVariable Integer action) {
    GameFollowDTO gameFollowDTO = followGameService.followOrIgnoreGame(userId, gameId, action);
    return new ResponseEntity<>(gameFollowDTO, HttpStatus.OK);
  }
}
