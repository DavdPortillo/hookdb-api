package com.winningstation.services;

import com.winningstation.entity.Platform;
import com.winningstation.repository.PlatformRepository;
import com.winningstation.services.interfaces.IPlatformService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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
}
