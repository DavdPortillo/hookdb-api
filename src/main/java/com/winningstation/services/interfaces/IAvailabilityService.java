package com.winningstation.services.interfaces;

import com.winningstation.entity.Availability;

/**
 * Interfaz que define los métodos que se pueden realizar sobre la disponibilidad de un juego.
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
