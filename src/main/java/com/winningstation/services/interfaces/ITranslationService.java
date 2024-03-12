package com.winningstation.services.interfaces;

import com.winningstation.entity.Translation;

import java.util.List;

public interface ITranslationService {

  /**
   * * Método que permite guardar un producto.
   *
   * @param translation traducción a guardar.
   */
  Translation save(Translation translation);

  /**
   * Método que permite obtener por su id.
   *
   * @param id a obtener.
   * @return traducción obtenida.
   */
  Translation findById(Long id);

  /**
   * Método que permite obtener todos los registros.
   *
   * @return Lista con todas los registros.
   */
  List<Translation> findAll();

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
   * @param request traducción a actualizar.
   * @return la traducción actualizada.
   */
  String update(Long id, String request);

  /**
   * Método que permite obtener registros por su nombre.
   *
   * @param name Nombre a obtener.
   * @return La traducción obtenida.
   */
  List<Translation> findByName(String name);
}
