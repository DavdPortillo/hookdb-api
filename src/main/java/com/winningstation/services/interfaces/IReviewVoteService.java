package com.winningstation.services.interfaces;

import com.winningstation.entity.ReviewVote;
import com.winningstation.projection.ReviewVoteProjection;

import java.util.List;

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

  /**
   * Borra el voto de una crítica.
   *
   * @param reviewId Id de la crítica.
   * @param userId Id del usuario.
   */
  void deleteVote(Long reviewId, Long userId);

  List<ReviewVoteProjection> findUserVoteForGame(Long gameId, Long userId);
}
