package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.Availability;

/**
 * Repositorio de la disponibilidad de los juegos.
 *
 * @author David Portillo Hoyos
 */
public interface IAvailabilityService {

  /**
   * Método que guarda la disponibilidad de un juego en la base de datos.
   *
   * @param availability Disponibilidad a guardar.
   * @return Disponibilidad guardada.
   */
  Availability save(Availability availability);
}
