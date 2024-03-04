package com.winningstation.services;

import com.winningstation.entity.Distributor;
import com.winningstation.repository.DistributorRepository;
import com.winningstation.services.interfaces.IDistributorService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Servicio de distribuidor.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class DistributorService implements IDistributorService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(DistributorService.class);

  /** Repositorio de distribuidor. */
  private final DistributorRepository distributorRepository;

  /**
   * Constructor de la clase.
   *
   * @param distributorRepository Repositorio de distribuidor.
   */
  public DistributorService(DistributorRepository distributorRepository) {
    this.distributorRepository = distributorRepository;
  }

  /**
   * Guarda un distribuidor.
   *
   * @param distributor Distribuidor a guardar.
   * @return Distribuidor guardado.
   */
  public Distributor save(Distributor distributor) {
    LOG.info("Saving distributor: {}", distributor);
    distributorRepository.save(distributor);
    return distributor;
  }
}