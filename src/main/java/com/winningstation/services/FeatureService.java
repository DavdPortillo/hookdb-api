package com.winningstation.services;

import com.winningstation.entity.Feature;
import com.winningstation.repository.FeatureRepository;
import com.winningstation.services.interfaces.IFeatureService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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

  @Override
  public Feature findById(Long id) {
    LOG.info("Finding feature by id: {}", id);
    return featureRepository.findById(id).orElse(null);
  }

  @Override
  public void deleteById(Long id) {
    LOG.info("Deleting feature by id: {}", id);
    if (featureRepository.existsById(id)) {
      featureRepository.deleteById(id);
    } else {
      LOG.error("Feature with id {} not found", id);
      throw new RuntimeException("Feature with id " + id + " not found");
    }
  }

  @Override
  public List<Feature> findAll() {
    LOG.info("Finding all features");
    return featureRepository.findAll();
  }

  @Override
  public List<Feature> findByName(String name) {
    LOG.info("Finding feature by name: {}", name);
    return featureRepository.findByNameContaining(name);
  }

  @Override
  public String editByName(Long id, String name) {
    LOG.info("Editing feature by id: {}", id);
    Feature feature = featureRepository.findById(id).orElse(null);
    if (feature != null && name != null && !name.isEmpty()) {
      feature.setName(name);
      featureRepository.save(feature);
      return name;
    } else {
      LOG.error("Feature with id {} not found", id);
      throw new RuntimeException("Feature with id " + id + " not found");
    }
  }
}
