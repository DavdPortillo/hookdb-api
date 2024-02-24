package com.winninginnovations.services;

import com.winninginnovations.entity.SystemRequirement;
import com.winninginnovations.repository.SystemRequirementRepository;
import com.winninginnovations.services.interfaces.ISystemRequirementService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Servicio de requisitos del sistema.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class SystemRequirementService implements ISystemRequirementService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(SystemRequirementService.class);

  /** Repositorio de requisitos del sistema. */
  private final SystemRequirementRepository systemRequirementRepository;

  /**
   * Constructor de la clase.
   *
   * @param systemRequirementRepository Repositorio de requisitos del sistema.
   */
  public SystemRequirementService(SystemRequirementRepository systemRequirementRepository) {
    this.systemRequirementRepository = systemRequirementRepository;
  }

  /**
   * Guarda un requisito del sistema.
   *
   * @param systemRequirement Requisito del sistema a guardar.
   * @return Requisito del sistema guardado.
   */
  @Override
  public SystemRequirement save(SystemRequirement systemRequirement) {
    LOG.info("Saving system requirement: {}", systemRequirement);
    systemRequirementRepository.save(systemRequirement);
    return systemRequirement;
  }
}
