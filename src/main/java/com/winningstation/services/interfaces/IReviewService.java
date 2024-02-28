package com.winningstation.services.interfaces;

import com.winningstation.entity.Review;

import java.util.Map;

/**
 * Interfaz que define los métodos que se pueden realizar sobre las críticas de un juego.
 *
 * @author David Portillo Hoyos
 */
public interface IReviewService {

  /**
   * Método que guarda una crítica en la base de datos.
   *
   * @param review Crítica a guardar.
   * @return Crítica guardada.
   */
  Review save(Review review, Long gameId, Long userId);

  /**
   * Encuentra todas las críticas de un juego.
   *
   * @param gameId Id del juego.
   * @return Lista de críticas del juego.
   */
  Iterable<Review> findAllByGameId(Long gameId);

  /**
   * Encuentra los votos de una crítica.
   *
   * @param reviewId
   * @return Mapa con los votos de la crítica.
   */
  Map<String, Integer> getReviewVotes(Long reviewId);
}
