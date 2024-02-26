package com.winningstation.services.interfaces;

import com.winningstation.entity.NumberPlayer;

/**
 * Interfaz que define los métodos que se pueden realizar sobre el número de jugadores de un juego.
 *
 * @author David Portillo Hoyos
 */
public interface INumberPlayerService {

  /**
   * Método que guarda el número de jugadores de un juego en la base de datos.
   *
   * @param numberPlayer Número de jugadores a guardar.
   * @return Número de jugadores guardado.
   */
  NumberPlayer save(NumberPlayer numberPlayer);
}
