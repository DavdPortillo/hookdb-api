package com.winninginnovations.services;

import com.winninginnovations.entity.Review;
import com.winninginnovations.entity.ReviewVote;
import com.winninginnovations.entity.User;
import com.winninginnovations.repository.ReviewRepository;
import com.winninginnovations.repository.ReviewVoteRepository;
import com.winninginnovations.repository.UserRepository;
import com.winninginnovations.services.interfaces.IReviewVoteService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
    // Validar el voto
    if (vote != 1 && vote != -1) {
      throw new IllegalArgumentException("El voto debe ser +1 o -1");
    }

    // Encuentra al usuario por su ID
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));

    // Encuentra la revisión por su ID
    Review review = reviewRepository.findById(reviewId)
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

}
