package com.winningstation.repository;

import com.winningstation.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de Distributor. Extiende de JpaRepository para proporcionar métodos CRUD para la
 * entidad Distributor.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {

  /**
   * Método que busca un distribuidor por su nombre.
   *
   * @param name Nombre del distribuidor a buscar.
   * @return Distribuidor encontrado.
   */
  List<Distributor> findByNameContaining(String name);
}
