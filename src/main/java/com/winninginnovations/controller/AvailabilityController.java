package com.winninginnovations.controller;

import com.winninginnovations.entity.Availability;
import com.winninginnovations.services.interfaces.IAvailabilityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que representa los juegos que tiene un juego.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/availability")
public class AvailabilityController {

  /** Servicio para las plataformas. */
  private final IAvailabilityService availabilityService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param availabilityService Servicio para las plataformas.
   */
  public AvailabilityController(IAvailabilityService availabilityService) {
    this.availabilityService = availabilityService;
  }

  /**
   * Guarda un nuevo availability.
   *
   * @param availability El availability a guardar.
   * @return Availability guardado.
   */
  @PostMapping
  public Availability saveAvailability(@RequestBody Availability availability) {
    availabilityService.save(availability);
    return availability;
  }
}
