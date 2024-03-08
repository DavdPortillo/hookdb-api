package com.winningstation.controller;

import com.winningstation.entity.FollowGame;
import com.winningstation.services.interfaces.IFollowGameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para el seguimiento de juegos.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Follow Game Controller", description = "Operaciones para el seguimiento de juegos")
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

  @PostMapping("/user/{userId}/game/{gameId}/followOrIgnore/{action}")
  @Operation(
      summary = "Sigue o ignora un juego",
      description =
          "Sigue o ignora un juego basado en los identificadores de usuario y juego proporcionados y la acción, y devuelve el estado de seguimiento del juego")
  public ResponseEntity<FollowGame> followOrIgnoreGame(
      @PathVariable Long userId, @PathVariable Long gameId, @PathVariable Integer action) {
    FollowGame followGame = followGameService.followOrIgnoreGame(userId, gameId, action);
    return new ResponseEntity<>(followGame, HttpStatus.OK);
  }

  @GetMapping("userId/{userId}/followedOrIgnoreGames")
  @Operation(
      summary = "Obtiene los juegos seguidos o ignorados por un usuario",
      description =
          "Devuelve una lista de juegos seguidos o ignorados por un usuario basado en el identificador de usuario proporcionado")
  public ResponseEntity<List<FollowGame>> getFollowedOrIgnoreGames(@PathVariable Long userId) {
    List<FollowGame> followedGames = followGameService.getFollowedOrIgnoredGames(userId);
    return new ResponseEntity<>(followedGames, HttpStatus.OK);
  }

  @GetMapping("userId/{userId}/ignoredGames")
  @Operation(
      summary = "Obtiene los juegos ignorados por un usuario",
      description =
          "Devuelve una lista de juegos ignorados por un usuario basado en el identificador de usuario proporcionado")
  public ResponseEntity<List<FollowGame>> getIgnoredGames(@PathVariable Long userId) {
    List<FollowGame> ignoredGames = followGameService.getIgnoredGames(userId);
    return new ResponseEntity<>(ignoredGames, HttpStatus.OK);
  }

  @GetMapping("userId/{userId}/followedGames")
  @Operation(
      summary = "Obtiene los juegos seguidos por un usuario",
      description =
          "Devuelve una lista de juegos seguidos por un usuario basado en el identificador de usuario proporcionado")
  public ResponseEntity<List<FollowGame>> getFollowedGames(@PathVariable Long userId) {
    List<FollowGame> followedGames = followGameService.getFollowedGames(userId);
    return new ResponseEntity<>(followedGames, HttpStatus.OK);
  }

  @GetMapping("userId/{userId}/game/{gameId}")
  @Operation(
      summary = "Obtiene el estado de seguimiento de un juego por un usuario",
      description =
          "Devuelve el estado de seguimiento de un juego por un usuario basado en los identificadores de usuario y juego proporcionados")
  public ResponseEntity<Integer> getFollowGame(
      @PathVariable Long userId, @PathVariable Long gameId) {
    Integer followGame = followGameService.getFollowGame(userId, gameId);
    return new ResponseEntity<>(followGame, HttpStatus.OK);
  }
}
