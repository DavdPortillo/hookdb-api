package com.winningstation.services.interfaces;

import com.winningstation.entity.Developer;

import java.util.List;

/**
 * Interfaz que define los métodos que se pueden realizar sobre los desarrolladores de los juegos.
 *
 * @author David Portillo Hoyos
 */
public interface IDeveloperService {

  /**
   * Método que permite guardar un desarrollador de juego.
   *
   * @param developer Desarrollador de juego a guardar.
   * @return El desarrollador de juego guardado.
   */
  Developer save(Developer developer);

  /**
   * Elimina un desarrollador de juego.
   *
   * @param id Identificador del desarrollador de juego a eliminar.
   */
  void delete(Long id);

  /**
   * Busca un desarrollador de juego por su nombre.
   *
   * @param name Nombre del desarrollador de juego a buscar.
   * @return El desarrollador de juego encontrado.
   */
  List<Developer> findByNameContaining(String name);

  /**
   * Busca un desarrollador de juego por su id.
   *
   * @param id Identificador del desarrollador de juego a buscar.
   * @return El desarrollador de juego encontrado.
   */
  Developer findById(Long id);

  /**
   * Edita un desarrollador de juego.
   *
   * @param id Identificador del desarrollador de juego a editar.
   * @param developerRequest Desarrollador de juego a editar.
   * @return El desarrollador de juego editado.
   */
  Developer edit(Long id, Developer developerRequest);
}
