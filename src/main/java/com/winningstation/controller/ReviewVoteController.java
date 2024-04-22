package com.winningstation.controller;

import com.winningstation.entity.ReviewVote;
import com.winningstation.projection.ReviewVoteProjection;
import com.winningstation.services.interfaces.IReviewVoteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador que representa el voto de una crítica
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Review Vote Controller", description = "Operaciones para los votos de las críticas")
@RestController
@RequestMapping("/review-vote")
public class ReviewVoteController {

  /** Servicio de voto de crítica. */
  private final IReviewVoteService reviewVoteService;

  /**
   * Constructor de la clase.
   *
   * @param reviewVoteService Servicio de voto de crítica.
   */
  public ReviewVoteController(IReviewVoteService reviewVoteService) {
    this.reviewVoteService = reviewVoteService;
  }

  @PreAuthorize("#userId == authentication.principal.id")
  @PostMapping("/user/{userId}/review/{reviewId}/vote/{vote}")
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Vota una crítica",
      description =
          "Vota una crítica basado en los identificadores de usuario, crítica y voto proporcionados y devuelve el voto de crítica creado")
  public ReviewVote voteReview(
      @PathVariable Long userId, @PathVariable Long reviewId, @PathVariable Integer vote) {
    return reviewVoteService.voteReview(userId, reviewId, vote);
  }

  @PreAuthorize("#userId == authentication.principal.id")
  @DeleteMapping("/user/{userId}/review/{reviewId}")
  @Operation(
      summary = "Borra un voto de crítica",
      description =
          "Borra un voto de crítica basado en los identificadores de usuario y crítica proporcionados")
  public void deleteVote(@PathVariable Long userId, @PathVariable Long reviewId) {
    reviewVoteService.deleteVote(userId, reviewId);
  }

  @Operation(
      summary = "Obtiene los votos que ha dado de las críticas de un juego por usuario",
      description =
          "Obtiene los votos que ha dado de las críticas de un juego por usuario basado en los identificadores de usuario y juego proporcionados y devuelve una lista de proyecciones de votos de crítica")
  @GetMapping("/user-vote/user/{userId}/game/{gameId}")
  public ResponseEntity<List<ReviewVoteProjection>> getUserVoteForGame(
      @PathVariable Long userId, @PathVariable Long gameId) {
    return ResponseEntity.ok(reviewVoteService.findUserVoteForGame(gameId, userId));
  }
}
