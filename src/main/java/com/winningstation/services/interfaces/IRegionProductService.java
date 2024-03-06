package com.winningstation.services.interfaces;

import com.winningstation.entity.RegionProduct;

import java.util.List;

/**
 * Interfaz que permite realizar operaciones sobre la entidad RegionProduct.
 *
 * @author David Portillo Hoyos
 */
public interface IRegionProductService {

  /**
   * Método que permite guardar un registro
   *
   * @param regionProduct Registro a guardar.
   */
  RegionProduct save(RegionProduct regionProduct);

  /**
   * Método que permite obtener por su id.
   *
   * @param id a obtener.
   * @return Registro obtenido.
   */
  RegionProduct findById(Long id);

  /**
   * Método que permite obtener todos los registros.
   *
   * @return Lista con todas los registros.
   */
  List<RegionProduct> findAll();

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
   * @param request Registro a actualizar.
   * @return el registro actualizado.
   */
  String update(Long id, String request);

  /**
   * Método que permite obtener registros por su nombre.
   *
   * @param name Nombre a obtener.
   * @return Los registros obtenidos.
   */
  List<RegionProduct> findByName(String name);
}
