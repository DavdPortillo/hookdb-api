package com.winninginnovations.repository;

import com.winninginnovations.entity.Review;
import com.winninginnovations.entity.ReviewVote;
import com.winninginnovations.entity.User;
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