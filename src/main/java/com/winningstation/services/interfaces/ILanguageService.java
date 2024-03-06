package com.winningstation.services.interfaces;

import com.winningstation.entity.Language;
import com.winningstation.entity.PlatformProduct;

import java.util.List;

/**
 * Interfaz que define los métodos que se pueden realizar sobre los idiomas de los juegos.
 *
 * @author David Portillo Hoyos
 */
public interface ILanguageService {

  /**
   * Método que permite guardar un idioma de juego.
   *
   * @param language Idioma de juego a guardar.
   * @return El idioma de juego guardado.
   */
  Language save(Language language);

  /**
   * Método que permite obtener por su id.
   *
   * @param id a obtener.
   * @return plataforma obtenida.
   */
  Language findById(Long id);

  /**
   * Método que permite obtener todos los registros.
   *
   * @return Lista con todas los registros.
   */
  List<Language> findAll();

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
  List<Language> findByName(String name);
}
