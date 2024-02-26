package com.winninginnovations.services;

import com.winninginnovations.entity.DLC;
import com.winninginnovations.repository.DLCRepository;
import com.winninginnovations.services.interfaces.IDLCService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Servicio de dlc.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class DLCService implements IDLCService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(DLCService.class);

  /** Repositorio de dlc. */
  private final DLCRepository dlcRepository;

  /**
   * Constructor de la clase.
   *
   * @param dlcRepository Repositorio de dlc.
   */
  public DLCService(DLCRepository dlcRepository) {
    this.dlcRepository = dlcRepository;
  }

  public DLC save(DLC dlc) {
    LOG.info("Saving dlc: {}", dlc);
    dlcRepository.save(dlc);
    return dlc;
  }
}
