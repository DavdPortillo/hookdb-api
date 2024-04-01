package com.winningstation.services.interfaces;

import com.winningstation.entity.VendorProduct;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Interfaz que define los métodos que se pueden realizar sobre los logos de los productos.
 *
 * @author David Portillo Hoyos
 */
public interface IVendorProductService {

  /**
   * Método que permite guardar un logo de producto.
   *
   * @param logo Logo de producto a guardar.
   * @return El logo de producto guardado.
   */
  VendorProduct save(VendorProduct logo, MultipartFile file);

  /**
   * Método que permite obtener un logo de producto por su id.
   *
   * @param id Id del logo de producto a obtener.
   * @return El logo de producto obtenido.
   */
  VendorProduct findById(Long id);

  /**
   * Método que permite obtener todos los logos de productos.
   *
   * @return Lista con todos los logos de productos.
   */
  List<VendorProduct> findAll();

  /**
   * Método que permite eliminar un logo de producto por su id.
   *
   * @param id Id del logo de producto a eliminar.
   */
  void deleteById(Long id);

  /**
   * Método que permite actualizar un logo de producto.
   *
   * @param id Id del logo de producto a actualizar.
   * @param newVendorProduct Nuevo logo de producto.
   * @param file Archivo de la imagen del logo de producto.
   * @return El logo de producto actualizado.
   */
  VendorProduct update(Long id, VendorProduct newVendorProduct, MultipartFile file);

  /**
   * Método que permite obtener un logo de producto por su nombre.
   *
   * @param name Nombre del logo de producto a obtener.
   * @return El logo de producto obtenido.
   */
  List<VendorProduct> findByName(String name);
}
