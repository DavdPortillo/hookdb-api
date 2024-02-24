package com.winninginnovations.services;

import com.winninginnovations.entity.Game;
import com.winninginnovations.entity.Review;
import com.winninginnovations.entity.User;
import com.winninginnovations.repository.GameRepository;
import com.winninginnovations.repository.ReviewRepository;
import com.winninginnovations.repository.UserRepository;
import com.winninginnovations.services.interfaces.IReviewService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
    review.setGame(game);

    return reviewRepository.save(review);
  }
}
