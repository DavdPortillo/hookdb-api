package com.winningstation.repository;

import com.winningstation.entity.DLC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de los dlcs de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface DLCRepository extends JpaRepository<DLC, Long> {

  List<DLC> findByNameContaining(String name);

  List<DLC> findByGameId(Long gameId);
}
