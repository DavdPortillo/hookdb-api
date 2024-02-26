package com.winningstation.services.interfaces;

import com.winningstation.entity.Feature;

/**
 * Interfaz que define los métodos que se pueden realizar sobre las características de un juego.
 *
 * @author David Portillo Hoyos
 */
public interface IFeatureService {
  /**
   * Método que guarda las características de un juego en la base de datos.
   *
   * @param feature Características a guardar.
   * @return Características guardadas.
   */
  Feature save(Feature feature);
}
