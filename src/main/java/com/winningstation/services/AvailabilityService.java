package com.winningstation.services;

import com.winningstation.entity.Availability;
import com.winningstation.repository.AvailabilityRepository;
import com.winningstation.services.interfaces.IAvailabilityService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Clase que representa los juegos que tiene un juego.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class AvailabilityService implements IAvailabilityService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(AvailabilityService.class);

  /** Repositorio de availability. */
  private final AvailabilityRepository availabilityRepository;

  /**
   * Constructor de la clase.
   *
   * @param availabilityRepository Repositorio de availability.
   */
  public AvailabilityService(AvailabilityRepository availabilityRepository) {
    this.availabilityRepository = availabilityRepository;
  }

  /**
   * Guarda un availability.
   *
   * @param availability Availability de juego a guardar.
   * @return Availability guardado.
   */
  @Override
  public Availability save(Availability availability) {
    LOG.info("Saving availability: {}", availability);
    availabilityRepository.save(availability);
    return availability;
  }
}
