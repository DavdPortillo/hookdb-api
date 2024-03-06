package com.winningstation.services.interfaces;

import com.winningstation.entity.Feature;

import java.util.List;

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

  /**
   * Método que obtiene las características de un juego por su id.
   *
   * @param id Id de las características a obtener.
   * @return Características obtenidas.
   */
  Feature findById(Long id);

  /**
   * Método que elimina las características de un juego por su id.
   *
   * @param id Id de las características a eliminar.
   */
  void deleteById(Long id);

  /**
   * Método que obtiene todas las características de los juegos.
   *
   * @return Características obtenidas.
   */
  List<Feature> findAll();

  /**
   * Método que obtiene las características de un juego por su nombre.
   *
   * @param name Nombre de las características a obtener.
   * @return Características obtenidas.
   */
  List<Feature> findByName(String name);

  /**
   * Edita por el nombre
   *
   * @param name Nombre
   * @param id Id
   */
  String editByName(Long id, String name);
}
