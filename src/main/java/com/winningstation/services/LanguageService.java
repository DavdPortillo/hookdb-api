package com.winningstation.services;

import com.winningstation.entity.Language;
import com.winningstation.repository.LanguageRepository;
import com.winningstation.services.interfaces.ILanguageService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Servicio que permite realizar operaciones sobre los idiomas de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class LanguageService implements ILanguageService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(LanguageService.class);

  /** Repositorio de idioma. */
  private final LanguageRepository languageRepository;

  /**
   * Constructor de la clase.
   *
   * @param languageRepository Repositorio de idioma.
   */
  public LanguageService(LanguageRepository languageRepository) {
    this.languageRepository = languageRepository;
  }

  /**
   * Guarda un idioma de juego.
   *
   * @param language Idioma de juego a guardar.
   * @return El idioma de juego guardado.
   */
  @Override
  public Language save(Language language) {
    LOG.info("Saving language: {}", language);
    languageRepository.save(language);
    return language;
  }
}
