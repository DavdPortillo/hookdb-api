package com.winningstation.services;

import com.winningstation.entity.Language;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.repository.LanguageRepository;
import com.winningstation.services.interfaces.ILanguageService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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

  @Override
  public Language findById(Long id) {
    LOG.info("Obteniendo idioma por id {}", id);
    return languageRepository.findById(id).orElse(null);
  }

  @Override
  public List<Language> findAll() {
    LOG.info("Obteniendo todos los idiomas");
    return languageRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    LOG.info("Eliminando idioma por id {}", id);
    languageRepository.deleteById(id);
  }

  @Override
  public String update(Long id, String request) {
    LOG.info("Actualizando idioma por id {}", id);
    Language language = findById(id);
    if (language == null) {
      throw new RuntimeException("Language not found");
    }
    if (request != null) {
      language.setName(request);
    }
    languageRepository.save(language);
    return request;
  }

  @Override
  public List<Language> findByName(String name) {
    LOG.info("Obteniendo idioma por nombre {}", name);
    return languageRepository.findByNameContaining(name);
  }
}
