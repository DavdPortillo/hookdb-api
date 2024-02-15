package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.Language;

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
}
