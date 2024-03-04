package com.winningstation.controller;

import com.winningstation.entity.FollowGame;
import com.winningstation.services.interfaces.IFollowGameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @PostMapping("/user/{userId}/game/{gameId}/followOrIgnore/{action}")
  public ResponseEntity<FollowGame> followOrIgnoreGame(
      @PathVariable Long userId, @PathVariable Long gameId, @PathVariable Integer action) {
    FollowGame followGame = followGameService.followOrIgnoreGame(userId, gameId, action);
    return new ResponseEntity<>(followGame, HttpStatus.OK);
  }

  @GetMapping("userId/{userId}/followedOrIgnoreGames")
  public ResponseEntity<List<FollowGame>> getFollowedOrIgnoreGames(@PathVariable Long userId) {
    List<FollowGame> followedGames = followGameService.getFollowedOrIgnoredGames(userId);
    return new ResponseEntity<>(followedGames, HttpStatus.OK);
  }

  @GetMapping("userId/{userId}/ignoredGames")
  public ResponseEntity<List<FollowGame>> getIgnoredGames(@PathVariable Long userId) {
    List<FollowGame> ignoredGames = followGameService.getIgnoredGames(userId);
    return new ResponseEntity<>(ignoredGames, HttpStatus.OK);
  }

  @GetMapping("userId/{userId}/followedGames")
  public ResponseEntity<List<FollowGame>> getFollowedGames(@PathVariable Long userId) {
    List<FollowGame> followedGames = followGameService.getFollowedGames(userId);
    return new ResponseEntity<>(followedGames, HttpStatus.OK);
  }
}
