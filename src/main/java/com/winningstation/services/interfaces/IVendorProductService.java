package com.winningstation.services.interfaces;

import com.winningstation.entity.PlatformProduct;
import com.winningstation.entity.VendorProduct;

import java.util.List;

/**
 * Interfaz que define los métodos que se pueden realizar sobre la entidad VendorProduct.
 *
 * @author David Portillo Hoyos
 */
public interface IVendorProductService {

  /**
   * Método que permite guardar un registro
   *
   * @param vendorProduct Registro a guardar.
   */
  VendorProduct save(VendorProduct vendorProduct);

  /**
   * Método que permite obtener por su id.
   *
   * @param id a obtener.
   * @return Registro obtenido.
   */
  VendorProduct findById(Long id);

  /**
   * Método que permite obtener todos los registros.
   *
   * @return Lista con todas los registros.
   */
  List<VendorProduct> findAll();

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
  List<VendorProduct> findByName(String name);
}
