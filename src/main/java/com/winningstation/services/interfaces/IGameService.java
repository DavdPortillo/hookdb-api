package com.winningstation.services.interfaces;

import com.winningstation.dto.*;
import com.winningstation.entity.*;
import com.winningstation.projection.GamePopularityProjection;
import com.winningstation.request.AvailabilityRequest;
import com.winningstation.request.GameFeatureRequest;
import com.winningstation.request.GameRequest;
import com.winningstation.request.ProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Interface que define los métodos que debe implementar la clase Game.
 *
 * @author David Portillo Hoyos
 */
public interface IGameService {



  List<GamePopularityProjection> getFiveGamesByDate(Long translationId);

  /**
   * Método que permite guardar un juego.
   *
   * @param gameRequest Parámetros para guardar el juego.
   * @return El juego guardado.
   */
  GameAndSagaDTO save(GameRequest gameRequest, MultipartFile file, Long translationId);

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
  Page<GameAdminDTO> findAllGames(Pageable pageable);

  /**
   * Método que permite obtener un juego por su id.
   *
   * @param id Id del juego a buscar.
   * @return El juego encontrado.
   */
  GameAndSagaDTO findById(Long id, Long translationId);

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
  List<ScoreAverageResultDTO> calculateAverageScoreOfLast100(Long gameId);

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
  List<GamePopularityProjection> findByDateAfterAndOrderByPopularityDesc(Long translationId);

  /**
   * Método que permite obtener los 5 juegos más populares a partir de una fecha dada.
   *
   * @return Lista de juegos más populares.
   */
  List<GamePopularityProjection> findTop5ByDateAfterAndOrderByPopularityDesc(Long translationId);

  /**
   * Método que permite buscar juegos por título donde tiene más peso la popularidad.
   *
   * @return Lista de juegos más populares.
   */
  List<GameSearchDTO> searchGames(String keyword, Long translationId);

  /**
   * Método que permite buscar sugerencias 5 por título donde tiene más peso la popularidad.
   *
   * @return Lista de juegos más populares.
   */
  List<GameSearchDTO> searchTop5Games(String keyword, Long translationId);

  /**
   * Método que permite actualizar un juego.
   *
   * @param id Id del juego a actualizar.
   * @param gameRequest Parámetros para actualizar el juego.
   * @return El juego actualizado.
   */
  GameAndSagaDTO updateGame(
      Long id, GameRequest gameRequest, MultipartFile file, Long translationId);

  /**
   * Obtiene o crea una saga.
   *
   * @param saga Saga a obtener o crear.
   * @return La saga obtenida o creada.
   */
  Saga getOrCreateSaga(Saga saga);

  /**
   * Permite crear availability a partir de una petición.
   *
   * @param availabilityRequests Lista de peticiones de availability.
   * @param game Juego al que pertenecen las availability.
   * @return Lista de availability creadas.
   */
  List<Availability> createAvailabilities(
      List<AvailabilityRequest> availabilityRequests, Game game);

  /**
   * Método que permite crear productos a partir de una petición.
   *
   * @param gameFeatureRequests Lista de peticiones de productos.
   * @return Lista de productos creados.
   */
  List<GameFeature> createGameFeatures(List<GameFeatureRequest> gameFeatureRequests);

  /**
   * Método que permite actualizar un juego a partir de una petición.
   *
   * @param game Juego a actualizar.
   * @param gameRequest Petición para actualizar el juego.
   */
  void updateGameFromRequest(Game game, GameRequest gameRequest, MultipartFile file);

  /**
   * Permite actualizar los requerimientos de un sistema.
   *
   * @param existingReq Requerimiento de sistema existente.
   * @param newReq Requerimiento de sistema nuevo.
   * @return Requerimiento de sistema actualizado.
   */
  SystemRequirement updateSystemRequirement(
      SystemRequirement existingReq, SystemRequirement newReq);

  /**
   * Permite actualizar las availability de un juego.
   *
   * @param game Juego al que pertenecen las availability.
   * @param availabilityRequest Petición de availability.
   * @return La availability actualizada.
   */
  Availability updateAvailability(Game game, AvailabilityRequest availabilityRequest);

  /**
   * Permite actualizar las características de un juego.
   *
   * @param game Juego al que pertenecen las características.
   * @param gameFeatureRequest Petición de características.
   * @return La característica actualizada.
   */
  GameFeature updateGameFeature(Game game, GameFeatureRequest gameFeatureRequest);

  /**
   * Permite actualizar un producto.
   *
   * @param game Juego al que pertenece el producto.
   * @param productRequest Petición de producto.
   * @return El producto actualizado.
   */
  Product updateProduct(Game game, ProductRequest productRequest);

  /**
   * Permite validar y obtener entidades a partir de una lista de ids.
   *
   * @param ids Lista de ids.
   * @param repository Repositorio de la entidad.
   * @param entityName Nombre de la entidad.
   * @param <T> Tipo de la entidad.
   * @return Lista de entidades obtenidas.
   */
  <T> List<T> validateAndGetEntities(
      List<Long> ids, JpaRepository<T, Long> repository, String entityName);

  /**
   * Permite crear productos a partir de una petición.
   *
   * @param productRequests Lista de peticiones de productos.
   * @param game Juego al que pertenecen los productos.
   * @return Lista de productos creados.
   */
  List<Product> createProducts(List<ProductRequest> productRequests, Game game);

  Page<GameSearchAdminDTO> searchGames(String keyword, Long translationId, Pageable pageable);
}
