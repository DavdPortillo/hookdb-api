package com.winningstation.services.interfaces;

import com.winningstation.dto.GameAndSagaDTO;
import com.winningstation.dto.ScoreAverageResultDTO;
import com.winningstation.entity.Game;
import com.winningstation.projection.GamePopularityProjection;
import com.winningstation.request.GameRequest;

import java.util.List;

/**
 * Interface que define los métodos que debe implementar la clase Game.
 *
 * @author David Portillo Hoyos
 */
public interface IGameService {

  /**
   * Método que permite guardar un juego.
   *
   * @param gameRequest Parámetros para guardar el juego.
   * @return El juego guardado.
   */
  GameAndSagaDTO save(GameRequest gameRequest);

  /**
   * Método que permite eliminar un juego.
   *
   * @param id Id del juego a eliminar.
   */
  void delete(Long id);

  /**
   * Método que permite obtener todos los juegos.
   *
   * @return Lista de todos los juegos.
   */
  Iterable<Game> findAll();

  /**
   * Método que permite obtener un juego por su id.
   *
   * @param id Id del juego a buscar.
   * @return El juego encontrado.
   */
  GameAndSagaDTO findById(Long id);

  /**
   * Método que permite obtener un juego por su id.
   *
   * @param id Id del juego a buscar.
   * @return El juego encontrado.
   */
  Game findByIdGame(Long id);

  /**
   * Método que calcula el promedio de puntuación de un juego y el número de puntuaciones.
   *
   * @param gameId Id del juego.
   * @return El promedio de puntuación del juego.
   */
  ScoreAverageResultDTO calculateAverageScore(Long gameId);

  /**
   * Método que calcula el promedio de los últimos 100 puntajes de un juego y el número de
   * puntuaciones.
   *
   * @param gameId Id del juego.
   * @return Lista de juegos que pertenecen al género.
   */
  ScoreAverageResultDTO calculateAverageScoreOfLast100(Long gameId);

  /**
   * Método que permite convertir un juego a un DTO.
   *
   * @param game Juego a convertir.
   * @return Juego convertido a DTO.
   */
  GameAndSagaDTO convertToGameAndSagaDTO(Game game);

  /**
   * Método que permite obtener los juegos más populares a partir de una fecha dada.
   *
   * @return Lista de juegos más populares.
   */
  List<GamePopularityProjection> findByDateAfterAndOrderByPopularityDesc();

  /**
   * Método que permite obtener los 5 juegos más populares a partir de una fecha dada.
   *
   * @return Lista de juegos más populares.
   */
  List<GamePopularityProjection> findTop5ByDateAfterAndOrderByPopularityDesc();
}
