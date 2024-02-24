package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.SystemRequirement;

/**
 * Interface de servicio para los requerimientos del sistema.
 *
 * @author David Portillo Hoyos
 */
public interface ISystemRequirementService {

  /**
   * Método que guarda los requerimientos del sistema en la base de datos.
   *
   * @param systemRequirement Requerimientos del sistema a guardar.
   * @return Requerimientos del sistema guardados.
   */
  SystemRequirement save(SystemRequirement systemRequirement);
}
