package com.winningstation.services;

import com.winningstation.entity.Review;
import com.winningstation.entity.ReviewVote;
import com.winningstation.entity.User;
import com.winningstation.projection.ReviewVoteProjection;
import com.winningstation.repository.ReviewRepository;
import com.winningstation.repository.ReviewVoteRepository;
import com.winningstation.repository.UserRepository;
import com.winningstation.services.interfaces.IReviewVoteService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que representa el voto de una crítica.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class ReviewVoteService implements IReviewVoteService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(ReviewVoteService.class);

  /** Repositorio de reviewVote. */
  private final ReviewVoteRepository reviewVoteRepository;

  /** Repositorio de review. */
  private final ReviewRepository reviewRepository;

  /** Repositorio de user. */
  private final UserRepository userRepository;


  /**
   * Constructor de la clase.
   *
   * @param reviewVoteRepository Repositorio de reviewVote.
   * @param reviewRepository Repositorio de review.
   * @param userRepository Repositorio de user.
   */
  public ReviewVoteService(
      ReviewVoteRepository reviewVoteRepository,
      ReviewRepository reviewRepository,
      UserRepository userRepository) {
    this.reviewVoteRepository = reviewVoteRepository;
    this.reviewRepository = reviewRepository;
    this.userRepository = userRepository;
  }

  @Override
  public ReviewVote voteReview(Long userId, Long reviewId, Integer vote) {

    LOG.info(
        "El usuario con ID {} está votando la review con ID {} con el voto {}",
        userId,
        reviewId,
        vote);
    // Validar el voto
    if (vote != 1 && vote != -1) {
      throw new IllegalArgumentException("El voto debe ser +1 o -1");
    }

    // Encuentra al usuario por su ID
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

    // Encuentra la revisión por su ID
    Review review =
        reviewRepository
            .findById(reviewId)
            .orElseThrow(() -> new IllegalArgumentException("Review no encontrada"));

    // Verificar que el usuario no esté votando su propia revisión
    if (review.getUser().getId().equals(user.getId())) {
      throw new IllegalArgumentException("Un usuario no puede votar su propia revisión");
    }

    // Verificar si el usuario ya votó la revisión
    ReviewVote existingVote = reviewVoteRepository.findByUserAndReview(user, review);
    if (existingVote != null) {
      // Si el usuario ya votó la revisión y su nuevo voto es diferente, actualizar el voto
      if (!existingVote.getVote().equals(vote)) {
        existingVote.setVote(vote);
        reviewVoteRepository.save(existingVote);
      }
      // Si el usuario ya votó la revisión y su nuevo voto es igual, no hacer nada
    } else {
      // Si el usuario no ha votado la revisión, crear un nuevo voto
      ReviewVote reviewVote = new ReviewVote();
      reviewVote.setUser(user);
      reviewVote.setReview(review);
      reviewVote.setVote(vote);

      reviewVoteRepository.save(reviewVote);
    }

    // Actualizar el conteo de likes y dislikes en la revisión
    review.setLike(reviewVoteRepository.countByReviewAndVote(review, 1));
    review.setDislike(reviewVoteRepository.countByReviewAndVote(review, -1));

    reviewRepository.save(review);

    return reviewVoteRepository.findByUserAndReview(user, review);
  }

  @Override
  public void deleteVote(Long userId, Long reviewId) {
    LOG.info(
        "El usuario con ID {} está eliminando su voto de la review con ID {}", userId, reviewId);
    // Encuentra al usuario por su ID
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    // Encuentra la revisión por su ID
    Review review =
        reviewRepository
            .findById(reviewId)
            .orElseThrow(() -> new IllegalArgumentException("Review no encontrada"));
    // Encuentra el voto del usuario en la revisión
    ReviewVote reviewVote = reviewVoteRepository.findByUserAndReview(user, review);
    if (reviewVote != null) {
      reviewVoteRepository.delete(reviewVote);
      // Actualizar el conteo de likes y dislikes en la revisión
      review.setLike(reviewVoteRepository.countByReviewAndVote(review, 1));
      review.setDislike(reviewVoteRepository.countByReviewAndVote(review, -1));
      reviewRepository.save(review);
    }
  }

  public List<ReviewVoteProjection> findUserVoteForGame(Long gameId, Long userId) {
    return reviewVoteRepository.findUserVoteForGame(gameId, userId);
  }
}
