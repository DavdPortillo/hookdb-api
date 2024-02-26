package com.winningstation.services;

import com.winningstation.entity.Saga;
import com.winningstation.repository.SagaRepository;
import com.winningstation.services.interfaces.ISagaService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa los métodos que se pueden realizar sobre las sagas de los juegos. Esta clase
 * implementa la interfaz ISagaService.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class SagaService implements ISagaService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(SagaService.class);

  /** Repositorio de saga. */
  private final SagaRepository sagaRepository;

  /**
   * Constructor de la clase.
   *
   * @param sagaRepository Repositorio de saga.
   */
  public SagaService(SagaRepository sagaRepository) {
    this.sagaRepository = sagaRepository;
  }

  /**
   * Guarda una saga.
   *
   * @param saga Saga a guardar.
   * @return Saga guardada.
   */
  @Override
  public Saga save(Saga saga) {
    LOG.info("Saving saga: {}", saga);
    sagaRepository.save(saga);
    return saga;
  }
}
