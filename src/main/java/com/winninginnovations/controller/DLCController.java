package com.winninginnovations.controller;

import com.winninginnovations.entity.DLC;
import com.winninginnovations.services.interfaces.IDLCService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que controla las peticiones relacionadas con los contenidos descargables de los
 * juegos. @Author David Portillo Hoyos
 */
@RestController
@RequestMapping("/dlc")
public class DLCController {

  /** Logger para la clase. */
  private static final Logger LOG = LoggerFactory.getLogger(DLCController.class);

  /** Servicio para los contenidos descargables. */
  private final IDLCService dlcService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param dlcService Servicio para los contenidos descargables.
   */
  public DLCController(IDLCService dlcService) {
    this.dlcService = dlcService;
  }

  /**
   * Guarda un nuevo contenido descargable.
   *
   * @param dlc El contenido descargable a guardar.
   * @return El contenido descargable guardado.
   */
  @PostMapping
  public DLC saveDLC(@RequestBody DLC dlc) {
    LOG.info("Saving DLC: {}", dlc);
    dlcService.save(dlc);
    return dlc;
  }
}
