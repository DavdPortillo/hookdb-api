package com.winningstation.controller;

import com.winningstation.entity.SystemRequirement;
import com.winningstation.services.interfaces.ISystemRequirementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para los requerimientos de sistema.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/system-requirement")
public class SystemRequirementController {

  /** Servicio para los requerimientos de sistema. */
  private final ISystemRequirementService systemRequirementService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param systemRequirementService Servicio para los requerimientos de sistema.
   */
  public SystemRequirementController(ISystemRequirementService systemRequirementService) {
    this.systemRequirementService = systemRequirementService;
  }

  /**
   * Guarda un nuevo requerimiento de sistema.
   *
   * @param systemRequirement El requerimiento de sistema a guardar.
   * @return Requerimiento de sistema guardado.
   */
  @PostMapping
  public SystemRequirement saveSystemRequirement(@RequestBody SystemRequirement systemRequirement) {
    systemRequirementService.save(systemRequirement);
    return systemRequirement;
  }
}
