package com.winningstation.repository;

import com.winningstation.dto.GameSearchDTO;
import com.winningstation.projection.GamePopularityProjection;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.winningstation.entity.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

/**
 * Repositorio de Game. Extiende de JpaRepository para proporcionar métodos CRUD para la entidad
 * Game.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

  /**
   * Método que permite obtener los 5 juegos más populares a partir de una fecha dada.
   *
   * @param date Fecha a partir de la cual se obtendrán los juegos.
   * @param pageable Objeto que permite la paginación de los resultados.
   * @return Lista de juegos más populares.
   */
  @Query(
      value =
          "SELECT g.id AS id, g.title AS title, g.cover AS cover, g.alt AS alt,g.popularity AS popularity ,g.date AS date FROM Game g WHERE g.date > :date ORDER BY g.popularity DESC")
  List<GamePopularityProjection> findTop5ByDateAfterAndOrderByPopularityDesc(
      LocalDate date, Pageable pageable);

  /**
   * Método que permite obtener los juegos más populares a partir de una fecha dada.
   *
   * @param date Fecha a partir de la cual se obtendrán los juegos.
   * @return Lista de juegos más populares.
   */
  @Query(
      value =
          "SELECT g.id AS id, g.title AS title, g.cover AS cover, g.alt AS alt,g.popularity AS popularity,g.date AS date  FROM Game g WHERE g.date > :date ORDER BY g.popularity DESC")
  List<GamePopularityProjection> findByDateAfterAndOrderByPopularityDesc(LocalDate date);

  /**
   * Método que permite buscar juegos por título donde tiene más peso la popularidad.
   *
   * @return Lista de juegos más populares.
   */
  @Query(
      "SELECT g FROM Game g WHERE LOWER(g.title) LIKE LOWER(CONCAT('%', :keyword, '%')) ORDER BY g.popularity DESC")
  List<Game> search(@Param("keyword") String keyword, Pageable pageable);
}
