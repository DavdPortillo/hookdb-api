package com.winninginnovations.repository;

import com.winninginnovations.entity.DLC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de los dlcs de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface DLCRepository extends JpaRepository<DLC, Long> {}
