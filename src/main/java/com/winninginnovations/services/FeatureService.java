package com.winninginnovations.services;

import com.winninginnovations.entity.Feature;
import com.winninginnovations.repository.FeatureRepository;
import com.winninginnovations.services.interfaces.IFeatureService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Servicio de feature.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class FeatureService implements IFeatureService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(FeatureService.class);

  /** Repositorio de feature. */
  private final FeatureRepository featureRepository;

  /**
   * Constructor de la clase.
   *
   * @param featureRepository Repositorio de feature.
   */
  public FeatureService(FeatureRepository featureRepository) {
    this.featureRepository = featureRepository;
  }

  /**
   * Guarda un feature.
   *
   * @param feature Feature de juego a guardar.
   * @return Feature guardado.
   */
  @Override
  public Feature save(Feature feature) {
    LOG.info("Saving feature: {}", feature);
    featureRepository.save(feature);
    return feature;
  }
}
