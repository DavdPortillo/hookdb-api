package com.winninginnovations.controller;

import com.winninginnovations.entity.Review;
import com.winninginnovations.services.interfaces.IReviewService;
import org.springframework.web.bind.annotation.*;

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
}
