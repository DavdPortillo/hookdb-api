package com.winningstation.services.interfaces;

import com.winningstation.entity.News;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Interface que define los métodos que debe implementar la clase News.
 *
 * @author David Portillo Hoyos
 */
public interface INewsService {

  /**
   * Método que permite obtener una noticia por su ID.
   *
   * @param id ID de la noticia.
   * @return La noticia con el ID especificado.
   */
  News findById(Long id);

  /**
   * Método que permite guardar una noticia.
   *
   * @param news Noticia a guardar.
   * @return La noticia guardada.
   */
  News save(News news);

  /**
   * Método que permite eliminar una noticia.
   *
   * @param id ID de la noticia a eliminar.
   */
  void delete(Long id);

  /**
   * Método que permite obtener todas las noticias.
   *
   * @return Lista de todas las noticias.
   */
  Iterable<News> findAll();

  /**
   * Método que permite obtener las noticias de los juegos seguidos por un usuario.
   *
   * @param userId ID del usuario.
   * @return Lista de noticias de los juegos seguidos por el usuario.
   */
  List<News> findNewsFromFollowedGames(@Param("userId") Long userId);

  /**
   * Método que permite obtener las noticias de los juegos seguidos por un usuario, excepto los
   * juegos que ha ignorado.
   *
   * @param userId ID del usuario.
   * @return Lista de noticias de los juegos seguidos por el usuario, excepto los juegos que ha
   *     ignorado.
   */
  List<News> getNewsExceptUnfollowedGames(Long userId);
}
