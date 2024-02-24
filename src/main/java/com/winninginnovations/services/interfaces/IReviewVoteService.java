package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.ReviewVote;

/**
 * Interfaz que representa el voto de una crítica.
 *
 * @author David Portillo Hoyos
 */
public interface IReviewVoteService {

  /**
   * Método que permite votar una crítica.
   *
   * @param reviewId Id de la crítica.
   * @param userId Id del usuario.
   * @param vote Voto del usuario.
   * @return Voto de la crítica.
   */
  ReviewVote voteReview(Long reviewId, Long userId, Integer vote);
}
