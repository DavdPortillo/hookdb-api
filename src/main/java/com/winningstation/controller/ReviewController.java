package com.winningstation.controller;

import com.winningstation.dto.ReviewTopThreeDTO;
import com.winningstation.entity.Review;
import com.winningstation.services.interfaces.IReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para las críticas de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Review Controller", description = "Operaciones para las críticas de los juegos")
@RestController
@RequestMapping("/review")
public class ReviewController {

  /** Servicio para las críticas. */
  private final IReviewService reviewService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param reviewService Servicio para las críticas.
   */
  public ReviewController(IReviewService reviewService) {
    this.reviewService = reviewService;
  }

  /**
   * Guarda un nuevo review.
   *
   * @param review El review a guardar.
   * @param gameId Id del juego al que pertenece el review.
   * @return Review guardado.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @PostMapping("/gameId/{gameId}/userId/{userId}")
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda una nueva crítica",
      description =
          "Guarda una nueva crítica basada en la petición proporcionada y devuelve la crítica guardada")
  public Review createReview(
      @RequestBody Review review, @PathVariable Long gameId, @PathVariable Long userId) {
    return reviewService.save(review, gameId, userId);
  }

  /**
   * Obtiene todas las críticas de un juego.
   *
   * @param gameId Id del juego.
   * @return Lista de críticas del juego.
   */
  @GetMapping("/game/{gameId}")
  @Operation(
      summary = "Obtiene todas las críticas de un juego",
      description =
          "Devuelve una lista de todas las críticas de un juego basado en el identificador de juego proporcionado")
  public Iterable<Review> getReviewsByGameId(@PathVariable Long gameId) {
    return reviewService.findAllByGameId(gameId);
  }

  /**
   * Obtiene los votos de una crítica.
   *
   * @param reviewId Id de la crítica.
   * @return Mapa con los votos de la crítica.
   */
  @GetMapping("/{reviewId}/votes")
  @Operation(
      summary = "Obtiene los votos de una crítica",
      description =
          "Devuelve un mapa con los votos de una crítica basado en el identificador de crítica proporcionado")
  public Map<String, Integer> getReviewVotes(@PathVariable Long reviewId) {
    return reviewService.getReviewVotes(reviewId);
  }

  /**
   * Obtiene todas las críticas de un usuario.
   *
   * @param userId Id del usuario.
   * @return Lista de críticas del usuario.
   */
  @PreAuthorize("#userId == authentication.principal.id")
  @GetMapping("/user/{userId}")
  @Operation(
      summary = "Obtiene todas las críticas de un usuario",
      description =
          "Devuelve una lista de todas las críticas de un usuario basado en el identificador de usuario proporcionado")
  public Iterable<Review> getReviewsByUserId(@PathVariable Long userId) {
    return reviewService.findAllByUserId(userId);
  }

  /**
   * Elimina una crítica por su id.
   *
   * @param id Id de la crítica a eliminar.
   */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina una crítica",
      description = "Elimina una crítica basada en el identificador proporcionado")
  public void deleteReviewById(@PathVariable Long id) {
    reviewService.deleteById(id);
  }

  @GetMapping("/top")
  @Operation(
      summary = "Obtiene las tres críticas más populares",
      description = "Devuelve una lista con las tres críticas más populares")
  public ResponseEntity<List<ReviewTopThreeDTO>> getTop3Reviews() {
    return ResponseEntity.ok(reviewService.findTop3Reviews());
  }
}
