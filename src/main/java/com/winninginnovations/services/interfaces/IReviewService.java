package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.Review;

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
}
