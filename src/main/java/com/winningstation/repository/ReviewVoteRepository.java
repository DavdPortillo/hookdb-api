package com.winningstation.repository;

import com.winningstation.entity.Review;
import com.winningstation.entity.ReviewVote;
import com.winningstation.entity.User;
import com.winningstation.projection.ReviewVoteProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase que representa el repositorio de los votos de las críticas.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface ReviewVoteRepository extends JpaRepository<ReviewVote, Long> {

  ReviewVote findByUserAndReview(User user, Review review);

  Integer countByReviewAndVote(Review review, Integer vote);

  @Query(
          value =
                  "SELECT r.id AS reviewId, rv.vote AS userVote "
                          + "FROM ReviewVote rv "
                          + "JOIN rv.review r "
                          + "JOIN r.game g "
                          + "WHERE g.id = :game_id AND rv.user.id = :user_id")
  List<ReviewVoteProjection> findUserVoteForGame(
          @Param("game_id") Long gameId, @Param("user_id") Long userId);
}