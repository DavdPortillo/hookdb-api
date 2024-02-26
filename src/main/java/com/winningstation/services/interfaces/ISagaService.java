package com.winningstation.services.interfaces;

import com.winningstation.entity.Saga;

/**
 * Interfaz que define los métodos que se pueden realizar sobre las sagas de los juegos.
 *
 * @author David Portillo Hoyos
 */
public interface ISagaService {

  /**
   * Guarda una saga en la base de datos.
   *
   * @param saga Saga a guardar.
   * @return Saga guardada.
   */
  Saga save(Saga saga);
}
