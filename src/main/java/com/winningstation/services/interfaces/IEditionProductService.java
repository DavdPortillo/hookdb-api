package com.winningstation.services.interfaces;

import com.winningstation.entity.EditionProduct;

import java.util.List;

/**
 * Interface for edition product
 *
 * @author David Portillo Hoyos
 */
public interface IEditionProductService {

  /**
   * Método que permite guardar un product de producto.
   *
   * @param editionProduct Edition product to save.
   * @return The saved edition product.
   */
  EditionProduct save(EditionProduct editionProduct);

  /**
   * Método que permite obtener una edición de producto por su id.
   *
   * @param id de la edición de producto a obtener.
   * @return La edición de producto obtenida.
   */
  EditionProduct findById(Long id);

  /**
   * Método que permite obtener todas las ediciones de productos.
   *
   * @return Lista con todas las ediciones de productos.
   */
  List<EditionProduct> findAll();

  /**
   * Método que permite eliminar una edición de producto por su id.
   *
   * @param id Id del logo de la edición de producto a eliminar.
   */
  void deleteById(Long id);

  /**
   * Método que permite actualizar la edición de producto.
   *
   * @param id Id del logo de la edición de producto a actualizar.
   * @param name Nombre de la edición de producto a actualizar.
   * @return la edición de producto actualizada.
   */
  String update(Long id, String name);

  /**
   * Método que permite obtener una edición de producto por su nombre.
   *
   * @param name Nombre de la edición de producto a obtener.
   * @return La edición de producto obtenida.
   */
  List<EditionProduct> findByName(String name);
}
