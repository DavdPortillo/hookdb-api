package com.winningstation.services.interfaces;

import com.winningstation.entity.Platform;

import java.util.List;

/**
 * Interface que define los métodos que debe implementar la clase Platform.
 *
 * @author David Portillo Hoyos
 */
public interface IPlatformService {

  /**
   * Método que permite guardar una plataforma.
   *
   * @param platform Plataforma a guardar.
   */
  void save(Platform platform);

  /**
   * Método que permite obtener por su id.
   *
   * @param id a obtener.
   * @return plataforma obtenida.
   */
  Platform findById(Long id);

  /**
   * Método que permite obtener todos los registros.
   *
   * @return Lista con todas los registros.
   */
  List<Platform> findAll();

  /**
   * Método que permite eliminar por su id.
   *
   * @param id Id a eliminar.
   */
  void deleteById(Long id);

  /**
   * Método que permite actualizar
   *
   * @param id Id a actualizar.
   * @param request Plataforma a actualizar.
   * @return la plataforma actualizada.
   */
  String update(Long id, String request);

  /**
   * Método que permite obtener registros por su nombre.
   *
   * @param name Nombre a obtener.
   * @return La plataforma obtenida.
   */
  List<Platform> findByName(String name);
}
