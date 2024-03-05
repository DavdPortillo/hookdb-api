package com.winningstation.services;

import com.winningstation.entity.Distributor;
import com.winningstation.repository.DistributorRepository;
import com.winningstation.services.interfaces.IDistributorService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de distribuidor.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class DistributorService implements IDistributorService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(DistributorService.class);

  /** Repositorio de distribuidor. */
  private final DistributorRepository distributorRepository;

  /**
   * Constructor de la clase.
   *
   * @param distributorRepository Repositorio de distribuidor.
   */
  public DistributorService(DistributorRepository distributorRepository) {
    this.distributorRepository = distributorRepository;
  }

  /**
   * Guarda un distribuidor.
   *
   * @param distributor Distribuidor a guardar.
   * @return Distribuidor guardado.
   */
  public Distributor save(Distributor distributor) {
    LOG.info("Saving distributor: {}", distributor);
    distributorRepository.save(distributor);
    return distributor;
  }

  /**
   * Busca un distribuidor por su nombre.
   *
   * @param name Nombre del distribuidor a buscar.
   * @return Distribuidor encontrado.
   */
  public List<Distributor> findByName(String name) {
    LOG.info("Finding distributor by name: {}", name);
    return distributorRepository.findByNameContaining(name);
  }

  /**
   * Busca un distribuidor por su id.
   *
   * @param id Id del distribuidor a buscar.
   * @return Distribuidor encontrado.
   */
  public Distributor findById(Long id) {
    LOG.info("Finding distributor by id: {}", id);
    return distributorRepository.findById(id).orElse(null);
  }

  /**
   * Elimina un distribuidor.
   *
   * @param id Id del distribuidor a eliminar.
   */
  public void delete(Long id) {
    LOG.info("Deleting distributor by id: {}", id);
    distributorRepository.deleteById(id);
  }

  /**
   * Edita el nombre de un distribuidor.
   *
   * @param id Id del distribuidor a editar.
   * @param name Nuevo nombre del distribuidor.
   * @return Nombre del distribuidor editado.
   */
  @Override
  public String editName(Long id, String name) {
    LOG.info("Editing distributor name by id: {}", id);
    Distributor distributor = distributorRepository.findById(id).orElse(null);
    if (distributor != null) {
      distributor.setName(name);
      distributorRepository.save(distributor);
      return distributor.getName();
    }
    return null;
  }

  /**
   * Busca todos los distribuidores.
   *
   * @return Lista de distribuidores encontrados.
   */
  @Override
  public List<Distributor> findAll() {
    LOG.info("Finding all distributors");
    return distributorRepository.findAll();
  }
}
