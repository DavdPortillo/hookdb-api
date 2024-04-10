package com.winningstation.repository;

import com.winningstation.dto.*;
import com.winningstation.projection.GamePopularityProjection;
import org.springframework.data.domain.Page;
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
          "SELECT g.id AS id, g.title AS title, g.cover AS cover, g.alt AS alt,g.popularity AS popularity ,g.date AS date FROM Game g WHERE g.date > :date AND g.translation.id = :translationId ORDER BY g.popularity DESC")
  List<GamePopularityProjection> findTop5ByDateAfterAndOrderByPopularityDesc(
      LocalDate date, @Param("translationId") Long translationId, Pageable pageable);

  /**
   * Método que permite obtener los juegos más populares a partir de una fecha dada.
   *
   * @param date Fecha a partir de la cual se obtendrán los juegos.
   * @return Lista de juegos más populares.
   */
  @Query(
      value =
          "SELECT g.id AS id, g.title AS title, g.cover AS cover, g.alt AS alt,g.popularity AS popularity,g.date AS date  FROM Game g WHERE g.date > :date AND g.translation.id = :translationId ORDER BY g.popularity DESC")
  List<GamePopularityProjection> findByDateAfterAndOrderByPopularityDesc(
      LocalDate date, @Param("translationId") Long translationId);

  @Query(
      value =
          "SELECT g.id AS id, g.title AS title, g.cover AS cover, g.alt AS alt, g.date AS date FROM Game g WHERE g.translation.id = :translationId ORDER BY g.date DESC")
  List<GamePopularityProjection> findTop5ByOrderByDateDesc(
      @Param("translationId") Long translationId, Pageable pageable);

  /**
   * Método que permite buscar juegos por título donde tiene más peso la popularidad.
   *
   * @return Lista de juegos más populares.
   */
  @Query(
      "SELECT g FROM Game g WHERE LOWER(g.title) LIKE LOWER(CONCAT('%', :keyword, '%')) AND g.translation.id = :translationId ORDER BY g.popularity DESC")
  List<Game> search(
      @Param("keyword") String keyword,
      @Param("translationId") Long translationId,
      Pageable pageable);

  /**
   * Cálculo de la puntuación media y el número de puntuaciones de un juego.
   *
   * @param gameId Id del juego.
   * @return Resultado con la puntuación media y el número de puntuaciones.
   */
  @Query(
      "SELECT new com.winningstation.dto.ScoreAverageResultDTO(AVG(gs.score), COUNT(gs)) FROM GameScore gs WHERE gs.game.id = :gameId")
  ScoreAverageResultDTO findAverageScoreAndCount(@Param("gameId") Long gameId);

  @Query(
      "SELECT new com.winningstation.dto.ScoreAverageResultDTO(AVG(gs.score), COUNT(gs)) "
          + "FROM GameScore gs "
          + "WHERE gs.game.id = :gameId "
          + "ORDER BY gs.date DESC")
  List<ScoreAverageResultDTO> findAverageScoreAndCountForGame(
      @Param("gameId") Long gameId, Pageable pageable);

  Game findByIdAndTranslationId(Long id, Long translationId);

  @Query(
          "SELECT new com.winningstation.dto.GameSearchAdminDTO(g.id, g.title, g.date, t.language) FROM Game g JOIN g.translation t WHERE LOWER(g.title) LIKE LOWER(CONCAT('%', :keyword, '%')) ORDER BY g.popularity DESC")
  Page<GameSearchAdminDTO> searchGames(
          @Param("keyword") String keyword,
          Pageable pageable);


  @Query("SELECT new com.winningstation.dto.GameAdminDTO(g.id, g.title, g.date) FROM Game g")
  Page<GameAdminDTO> findAllGames(Pageable pageable);
}
