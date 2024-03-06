package com.winningstation.services.interfaces;


import com.winningstation.entity.PlatformProduct;

import java.util.List;

/**
 * Interfaz que define los métodos que se pueden realizar sobre la entidad PlatformProduct.
 *
 * @author David Portillo Hoyos
 */
public interface IPlatformProductService {

  /**
   * Método que permite guardar una plataforma.
   *
   * @param platform Plataforma a guardar.
   */
  PlatformProduct save(PlatformProduct platform);

  /**
   * Método que permite obtener por su id.
   *
   * @param id a obtener.
   * @return plataforma obtenida.
   */
  PlatformProduct findById(Long id);

  /**
   * Método que permite obtener todos los registros.
   *
   * @return Lista con todas los registros.
   */
  List<PlatformProduct> findAll();

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
  PlatformProduct update(Long id, PlatformProduct request);

  /**
   * Método que permite obtener registros por su nombre.
   *
   * @param name Nombre a obtener.
   * @return La plataforma obtenida.
   */
  List<PlatformProduct> findByName(String name);
}
