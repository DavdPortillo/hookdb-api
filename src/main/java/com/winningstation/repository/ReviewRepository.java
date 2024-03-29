package com.winningstation.repository;

import com.winningstation.dto.ReviewTopThreeDTO;
import com.winningstation.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/** Clase que representa el repositorio de las críticas. */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
  Iterable<Review> findAllByGameId(Long gameId);
    Iterable<Review> findAllByUserId(Long userId);

  @Query("SELECT new com.winningstation.dto.ReviewTopThreeDTO(u.username, g.title, r.title, r.content, r.like, r.date) FROM Review r JOIN r.user u JOIN r.game g ORDER BY r.like DESC")
  Page<ReviewTopThreeDTO> findTopReviews(Pageable pageable);

}
