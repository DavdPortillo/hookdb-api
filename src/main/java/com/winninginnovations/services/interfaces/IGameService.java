package com.winninginnovations.services.interfaces;

import com.winninginnovations.DTO.GameAndSagaDTO;
import com.winninginnovations.DTO.GameDTO;
import com.winninginnovations.DTO.ScoreAverageResultDTO;
import com.winninginnovations.entity.Game;
import com.winninginnovations.request.GameRequest;

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
  Game save(GameRequest gameRequest);

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
}
