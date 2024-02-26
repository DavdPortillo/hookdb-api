package com.winningstation.repository;

import com.winningstation.entity.Review;
import com.winningstation.entity.ReviewVote;
import com.winningstation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase que representa el repositorio de los votos de las críticas.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface ReviewVoteRepository extends JpaRepository<ReviewVote, Long> {

  ReviewVote findByUserAndReview(User user, Review review);

    Integer countByReviewAndVote(Review review, Integer vote);
}
