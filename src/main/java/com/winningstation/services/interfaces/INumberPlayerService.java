package com.winningstation.services.interfaces;

import com.winningstation.entity.NumberPlayer;

import java.util.List;

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

  /**
   * Método que elimina el número de jugadores de un juego de la base de datos.
   *
   * @param numberPlayer Número de jugadores a eliminar.
   */
  void delete(NumberPlayer numberPlayer);

  /**
   * Método que obtiene todos los números de jugadores de la base de datos.
   *
   * @return Lista de números de jugadores obtenidos.
   */
    List<NumberPlayer> findAll();

  /**
   * Método que obtiene el número de jugadores de un juego de la base de datos.
   *
   * @param id Id del número de jugadores a obtener.
   * @return Número de jugadores obtenido.
   */
  NumberPlayer getById(Long id);

  /**
   * Método que actualiza el número de jugadores de un juego en la base de datos.
   *
   * @param numberPlayerRequest Número de jugadores a actualizar.
   * @return Número de jugadores actualizado.
   */
  Integer update(Long id, Integer numberPlayerRequest);

  /**
   * Método que obtiene el número de jugadores de un juego de la base de datos.
   *
   * @param numberPlayers Número de jugadores a obtener.
   * @return Número de jugadores obtenido.
   */
  NumberPlayer getByNumberPlayers(Integer numberPlayers);
}
