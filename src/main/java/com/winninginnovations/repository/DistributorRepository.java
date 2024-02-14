package com.winninginnovations.repository;

import com.winninginnovations.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de Distributor. Extiende de JpaRepository para proporcionar métodos
 * CRUD para la entidad Distributor.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface DistributorRepository extends JpaRepository<Distributor, Long> {
}
