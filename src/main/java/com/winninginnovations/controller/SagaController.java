package com.winninginnovations.controller;

import com.winninginnovations.entity.Saga;
import com.winninginnovations.services.interfaces.ISagaService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para las sagas.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/saga")
public class SagaController {

  /** Servicio para las sagas. */
  private final ISagaService sagaService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param sagaService Servicio para las sagas.
   */
  public SagaController(ISagaService sagaService) {
    this.sagaService = sagaService;
  }

  /**
   * Guarda un nuevo saga.
   *
   * @param saga El saga a guardar.
   * @return Saga guardado.
   */
  @PostMapping
  public Saga saveSaga(@RequestBody Saga saga) {
    sagaService.save(saga);
    return saga;
  }
}
