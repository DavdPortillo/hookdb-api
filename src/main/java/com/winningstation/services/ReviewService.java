package com.winningstation.services;

import com.winningstation.dto.ReviewTopThreeDTO;
import com.winningstation.entity.Game;
import com.winningstation.entity.Review;
import com.winningstation.entity.User;
import com.winningstation.repository.GameRepository;
import com.winningstation.repository.ReviewRepository;
import com.winningstation.repository.UserRepository;
import com.winningstation.services.interfaces.IReviewService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que representa los comentarios hechos por los usuarios.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class ReviewService implements IReviewService {

  /** LOGGER. */
  private static final Logger LOG = LoggerFactory.getLogger(ReviewService.class);

  /** Repositorio de review. */
  private final ReviewRepository reviewRepository;

  /** Repositorio de game. */
  private final GameRepository gameRepository;

  /** Repositorio de user. */
  private final UserRepository userRepository;

  /**
   * Constructor de la clase.
   *
   * @param reviewRepository Repositorio de review.
   */
  public ReviewService(
      ReviewRepository reviewRepository,
      GameRepository gameRepository,
      UserRepository userRepository) {
    this.reviewRepository = reviewRepository;
    this.gameRepository = gameRepository;
    this.userRepository = userRepository;
  }

  /**
   * Guarda una crítica en la base de datos.
   *
   * @param review Crítica a guardar.
   * @return Crítica guardada.
   */
  @Override
  public Review save(Review review, Long gameId, Long userId) {
    LOG.info("Guardando crítica: {}", review);

    User user =
            userRepository
                    .findById(userId)
                    .orElseThrow(
                            () -> new RuntimeException("No se encontró el usuario con el id: " + userId));
    review.setUser(user);

    Game game =
            gameRepository
                    .findById(gameId)
                    .orElseThrow(
                            () -> new RuntimeException("No se encontró el juego con el id: " + gameId));
    if (review.getLike() == null) {
      review.setLike(0);
    }
    if (review.getDislike() == null) {
      review.setDislike(0);
    }
    review.setGame(game);

    return reviewRepository.save(review);
  }


  /**
   * Encuentra todas las críticas de un juego.
   *
   * @param gameId Id del juego.
   * @return Lista de críticas del juego.
   */
  @Override
  public Iterable<Review> findAllByGameId(Long gameId) {
    LOG.info("Buscando críticas del juego con id: {}", gameId);
    return reviewRepository.findAllByGameId(gameId);
  }

  @Override
  public Map<String, Integer> getReviewVotes(Long reviewId) {
    Review review =
        reviewRepository
            .findById(reviewId)
            .orElseThrow(
                () -> new RuntimeException("No se encontró la crítica con el id: " + reviewId));
    Map<String, Integer> votes = new HashMap<>();
    votes.put("likes", review.getLike());
    votes.put("dislikes", review.getDislike());
    return votes;
  }

  @Override
    public Iterable<Review> findAllByUserId(Long userId) {
        LOG.info("Buscando críticas del usuario con id: {}", userId);
        return reviewRepository.findAllByUserId(userId);
    }

    @Override
    public void deleteById(Long id) {
        LOG.info("Eliminando crítica con id: {}", id);
        reviewRepository.deleteById(id);
    }

  @Override
  public List<ReviewTopThreeDTO> findTop7Reviews() {
    return reviewRepository.findTopReviews(PageRequest.of(0, 7)).getContent();
  }

}
