package com.winningstation.repository;

import com.winningstation.dto.DLCDto;
import com.winningstation.entity.DLC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

  @Query(
      "SELECT new com.winningstation.dto.DLCDto(d.id, d.name, d.date, d.sinopsis, d.image, d.alt, g.title) FROM DLC d JOIN d.game g WHERE g.id = :gameId")
  List<DLCDto> findByGameId(@Param("gameId") Long gameId);
}
