package com.winninginnovations.controller;

import com.winninginnovations.entity.Language;
import com.winninginnovations.services.interfaces.ILanguageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de la entidad Language.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/language")
public class LanguageController {

  /** Logger para la clase. */
  private static final Logger LOG = LoggerFactory.getLogger(LanguageController.class);

  /** Servicio para los idiomas. */
  private final ILanguageService languageService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param languageService Servicio para los idiomas.
   */
  public LanguageController(ILanguageService languageService) {
    this.languageService = languageService;
  }

  /**
   * Guarda un nuevo idioma.
   *
   * @param language El idioma a guardar.
   * @return El idioma guardado.
   */
  @PostMapping
  public Language saveLanguage(@RequestBody Language language) {
    languageService.save(language);
    return language;
  }
}
