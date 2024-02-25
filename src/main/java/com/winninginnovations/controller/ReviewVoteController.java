package com.winninginnovations.controller;

import com.winninginnovations.entity.ReviewVote;
import com.winninginnovations.services.interfaces.IReviewVoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador que representa el voto de una crítica
 *
 * @author David Portillo Hoyos
 */
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

  @PostMapping("/user/{userId}/review/{reviewId}/vote/{vote}")
  public ReviewVote voteReview(
      @PathVariable Long userId, @PathVariable Long reviewId, @PathVariable Integer vote) {
    return reviewVoteService.voteReview(reviewId, userId, vote);
  }
}
