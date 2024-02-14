package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.DLC;

/**
 * Interfaz que define los métodos que se pueden realizar sobre un dlc.
 *
 * @author David Portillo Hoyos
 */
public interface IDLCService {

  /**
   * Método que guarda un dlc en la base de datos.
   *
   * @param dlc Dlc a guardar.
   * @return Dlc guardado.
   */
  DLC save(DLC dlc);
}
