package com.winningstation.services;

import com.winningstation.entity.Developer;
import com.winningstation.repository.DeveloperRepository;
import com.winningstation.services.interfaces.IDeveloperService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DeveloperService implements IDeveloperService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(DeveloperService.class);

  /** Repositorio de developer. */
  private final DeveloperRepository developerRepository;

  /**
   * Constructor de la clase.
   *
   * @param developerRepository Repositorio de developer.
   */
  public DeveloperService(DeveloperRepository developerRepository) {
    this.developerRepository = developerRepository;
  }

  /**
   * Guarda un developer.
   *
   * @param developer Developer de juego a guardar.
   * @return Developer guardado.
   */
  @Override
  public Developer save(Developer developer) {
    LOG.info("Saving developer: {}", developer);
    developerRepository.save(developer);
    return developer;
  }

  /**
   * Elimina un developer.
   *
   * @param id Identificador del developer a eliminar.
   */
  @Override
  public void delete(Long id) {
    LOG.info("Deleting developer with id: {}", id);
    developerRepository.deleteById(id);
  }

  /**
   * Busca un developer por su nombre.
   *
   * @param name Nombre del developer a buscar.
   * @return Developer encontrado.
   */
  @Override
  public List<Developer> findByNameContaining(String name) {
    LOG.info("Finding developer by name: {}", name);
    return developerRepository.findByNameContaining(name);
  }

  /**
   * Busca un developer por su id.
   *
   * @param id Identificador del developer a buscar.
   * @return Developer encontrado.
   */
  @Override
  public Developer findById(Long id) {
    LOG.info("Finding developer by id: {}", id);
    return developerRepository.findById(id).orElse(null);
  }

  /**
   * Edita un developer.
   *
   * @param id Identificador del developer a editar.
   * @param developerRequest Developer a editar.
   * @return Developer editado.
   */
  @Override
  public Developer edit(Long id, Developer developerRequest) {
    LOG.info("Editing developer with id: {}", id);
    Developer developer = findById(id);
    if (developer != null) {
      developer.setName(developerRequest.getName());
      developerRepository.save(developer);
    }
    return developer;
  }
}
