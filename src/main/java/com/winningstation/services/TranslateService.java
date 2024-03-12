package com.winningstation.services;

import com.winningstation.entity.RegionProduct;
import com.winningstation.entity.Translation;
import com.winningstation.repository.RegionProductRepository;
import com.winningstation.repository.TranslationRepository;
import com.winningstation.services.interfaces.ITranslationService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio que permite realizar operaciones sobre la entidad RegionProduct.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class TranslateService implements ITranslationService {

  /** Logger */
  private static final Logger LOGGER = LoggerFactory.getLogger(TranslateService.class);

  /** Repositorio de Translation */
  private final TranslationRepository translationRepository;

  /**
   * Constructor
   *
   * @param translationRepository Repositorio de Translation
   */
  public TranslateService(TranslationRepository translationRepository) {
    this.translationRepository = translationRepository;
  }

  @Override
  public Translation save(Translation translation) {
    LOGGER.info("Guardando Translation {}", translation);
    return translationRepository.save(translation);
  }

  @Override
  public Translation findById(Long id) {
    LOGGER.info("Obteniendo Translation por id {}", id);
    return translationRepository.findById(id).orElse(null);
  }

  @Override
  public List<Translation> findAll() {
    LOGGER.info("Obteniendo todos los Translation");
    return translationRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    LOGGER.info("Eliminando RegionProduct por id {}", id);
    Translation translation = translationRepository.findById(id).orElse(null);
    if (translation != null) {
      translationRepository.deleteById(id);
    } else {
      throw new RuntimeException("Translation no encontrado");
    }
  }

  @Override
  public String update(Long id, String request) {
    LOGGER.info("Actualizando Translation por id {}", id);
    Translation translation = translationRepository.findById(id).orElse(null);
    if (translation != null) {
      translation.setLanguage(request);
      translationRepository.save(translation);
      return request;
    }
    return "Translation no encontrado";
  }

  @Override
  public List<Translation> findByName(String name) {
    LOGGER.info("Obteniendo Translation por nombre {}", name);
    return translationRepository.findByLanguageContaining(name);
  }
}
