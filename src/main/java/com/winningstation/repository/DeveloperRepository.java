package com.winningstation.repository;

import com.winningstation.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que define los métodos que se pueden realizar sobre los desarrolladores de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {
}
