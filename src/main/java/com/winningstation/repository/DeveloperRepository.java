package com.winningstation.repository;

import com.winningstation.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz que define los métodos que se pueden realizar sobre los desarrolladores de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long> {

  /**
   * Método que permite buscar un desarrollador de juego por su nombre.
   *
   * @param name Nombre del desarrollador de juego a buscar.
   * @return El desarrollador de juego encontrado.
   */
  List<Developer> findByNameContaining(String name);
}
