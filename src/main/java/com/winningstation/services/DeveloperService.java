package com.winningstation.services;

import com.winningstation.entity.Developer;
import com.winningstation.repository.DeveloperRepository;
import com.winningstation.services.interfaces.IDeveloperService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeveloperService implements IDeveloperService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(DeveloperService.class);

  /** Repositorio de developer. */
  private final DeveloperRepository developerRepository;

  /**
   * Constructor de la clase.
   *
   * @param developerRepository Repositorio de developer.
   */
  public DeveloperService(DeveloperRepository developerRepository) {
    this.developerRepository = developerRepository;
  }

  /**
   * Guarda un developer.
   *
   * @param developer Developer de juego a guardar.
   * @return Developer guardado.
   */
  @Override
  public Developer save(Developer developer) {
    LOG.info("Saving developer: {}", developer);
    developerRepository.save(developer);
    return developer;
  }
}
