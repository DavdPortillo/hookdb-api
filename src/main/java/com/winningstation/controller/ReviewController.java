package com.winningstation.controller;

import com.winningstation.entity.Review;
import com.winningstation.services.interfaces.IReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/** Controlador para las críticas de los juegos. */
@RestController
@RequestMapping("/review")
public class ReviewController {

  /** Servicio para las críticas. */
  private final IReviewService reviewService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param reviewService Servicio para las críticas.
   */
  public ReviewController(IReviewService reviewService) {
    this.reviewService = reviewService;
  }

  /**
   * Guarda un nuevo review.
   *
   * @param review El review a guardar.
   * @param gameId Id del juego al que pertenece el review.
   * @return Review guardado.
   */
  @PostMapping("/{gameId}/{userId}")
  public Review createReview(
      @RequestBody Review review, @PathVariable Long gameId, @PathVariable Long userId) {
    return reviewService.save(review, gameId, userId);
  }

  /**
   * Obtiene todas las críticas de un juego.
   *
   * @param gameId Id del juego.
   * @return Lista de críticas del juego.
   */
  @GetMapping("/game/{gameId}")
  public Iterable<Review> getReviewsByGameId(@PathVariable Long gameId) {
    return reviewService.findAllByGameId(gameId);
  }

  /**
   * Obtiene los votos de una crítica.
   *
   * @param reviewId Id de la crítica.
   * @return Mapa con los votos de la crítica.
   */
  @GetMapping("/{reviewId}/votes")
  public Map<String, Integer> getReviewVotes(@PathVariable Long reviewId) {
    return reviewService.getReviewVotes(reviewId);
  }
}
