package com.winningstation.repository;

import com.winningstation.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la disponibilidad de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {}
