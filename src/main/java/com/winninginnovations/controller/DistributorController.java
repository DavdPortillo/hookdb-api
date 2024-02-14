package com.winninginnovations.controller;

import com.winninginnovations.entity.Distributor;
import com.winninginnovations.services.interfaces.IDistributorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que controla las peticiones relacionadas con los distribuidores de los juegos.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/distributor")
public class DistributorController {

  /** Logger para la clase. */
  private static final Logger LOG = LoggerFactory.getLogger(DistributorController.class);

  /** Servicio para los distribuidores. */
  private final IDistributorService distributorService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param distributorService Servicio para los distribuidores.
   */
  public DistributorController(IDistributorService distributorService) {
    this.distributorService = distributorService;
  }

  /**
   * Guarda un nuevo distribuidor.
   *
   * @param distributor El distribuidor a guardar.
   * @return El distribuidor guardado.
   */
  @PostMapping
  public Distributor saveDistributor(@RequestBody Distributor distributor) {
    LOG.info("Saving distributor: {}", distributor);
    distributorService.save(distributor);
    return distributor;
  }
}
