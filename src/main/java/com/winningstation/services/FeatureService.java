package com.winningstation.services;

import com.winningstation.entity.Feature;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.repository.FeatureRepository;
import com.winningstation.services.interfaces.IFeatureService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

  private final FileStorageService fileStorageService;

  /**
   * Constructor de la clase.
   *
   * @param featureRepository Repositorio de feature.
   */
  public FeatureService(FeatureRepository featureRepository,
                        FileStorageService fileStorageService) {
    this.featureRepository = featureRepository;
    this.fileStorageService = fileStorageService;
  }

  /**
   * Guarda un feature.
   *
   * @param feature Feature de juego a guardar.
   * @return Feature guardado.
   */
  @Override
  public Feature save(Feature feature, MultipartFile file) {
    LOG.info("Guardando plataforma");
    String fileDownloadUri = fileStorageService.storeFileAndGenerateUri(file);
    feature.setImage(fileDownloadUri);
    return featureRepository.save(feature);
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
  public Feature update(Long id, Feature request, MultipartFile file) {
    LOG.info("Actualizando plataforma por id {}", id);
    Feature feature = findById(id);
    if (feature == null) {
      throw new RuntimeException("Platform product not found");
    }
    if (request.getName() != null) {
      feature.setName(request.getName());
    }
    if (file != null) {
      String fileDownloadUri = fileStorageService.replaceFileAndGenerateUri(file, feature.getImage());
      feature.setImage(fileDownloadUri);
    }
    if (request.getAlt() != null) {
      feature.setAlt(request.getAlt());
    }
    return featureRepository.save(feature);
  }
}
