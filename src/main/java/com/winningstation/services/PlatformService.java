package com.winningstation.services;

import com.winningstation.entity.Platform;
import com.winningstation.repository.PlatformRepository;
import com.winningstation.services.interfaces.IPlatformService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service que permite realizar operaciones con la entidad Platform.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class PlatformService implements IPlatformService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(PlatformService.class);

  /** Repositorio de Platform. */
  private final PlatformRepository platformRepository;

  /**
   * Constructor de la clase.
   *
   * @param platformRepository Repositorio de Platform.
   */
  public PlatformService(PlatformRepository platformRepository) {
    this.platformRepository = platformRepository;
  }

  /**
   * @param platform Plataforma a guardar.
   */
  @Override
  public void save(Platform platform) {
    LOG.info("Saving platform: {}", platform);
    platformRepository.save(platform);
  }

  @Override
  public Platform findById(Long id) {
    LOG.info("Obteniendo plataforma por id {}", id);
    return platformRepository.findById(id).orElse(null);
  }

  @Override
  public List<Platform> findAll() {
    LOG.info("Obteniendo todas las plataformas");
    return platformRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    LOG.info("Eliminando plataforma por id {}", id);
    platformRepository.deleteById(id);
  }

  @Override
  public String update(Long id, String request) {
    LOG.info("Actualizando plataforma por id {}", id);
    Platform platform = platformRepository.findById(id).orElse(null);
    if (platform != null) {
      platform.setName(request);
      platformRepository.save(platform);
      return request;
    } else {
      throw new RuntimeException("Platform not found");
    }
  }

  @Override
  public List<Platform> findByName(String name) {
    LOG.info("Obteniendo plataforma por nombre {}", name);
    return platformRepository.findByNameContaining(name);
  }
}
