package com.winningstation.services.interfaces;

import com.winningstation.entity.KeysProduct;

import java.util.List;

/**
 * Interfaz que define realizar operaciones sobre la entidad KeysProduct.
 *
 * @author David Portillo Hoyos
 */
public interface IKeysProductService {

  /**
   * Método que permite guardar un registro
   *
   * @param keysProduct Registro a guardar.
   */
  KeysProduct save(KeysProduct keysProduct);

  /**
   * Método que permite obtener por su id.
   *
   * @param id a obtener.
   * @return Registro obtenido.
   */
  KeysProduct findById(Long id);

  /**
   * Método que permite obtener todos los registros.
   *
   * @return Lista con todas los registros.
   */
  List<KeysProduct> findAll();

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
  List<KeysProduct> findByName(String name);
}
