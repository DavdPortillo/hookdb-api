package com.winningstation.services.interfaces;

import com.winningstation.dto.NewsAdminDTO;
import com.winningstation.dto.NewsDTO;
import com.winningstation.entity.News;
import org.springframework.data.repository.query.Param;
import org.springframework.web.multipart.MultipartFile;

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
  News save(News news, MultipartFile file, Long authorId, Long gameId, Long translationId);

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
  Iterable<News> findAll(Long translationId);

  /**
   * Método que permite obtener las noticias de los juegos seguidos por un usuario.
   *
   * @param userId ID del usuario.
   * @return Lista de noticias de los juegos seguidos por el usuario.
   */
  List<News> findNewsFromFollowedGames(Long userId, Long translationId);

  /**
   * Método que permite obtener las noticias de los juegos seguidos por un usuario, excepto los
   * juegos que ha ignorado.
   *
   * @param userId ID del usuario.
   * @return Lista de noticias de los juegos seguidos por el usuario, excepto los juegos que ha
   *     ignorado.
   */
  List<News> getNewsExceptUnfollowedGames(Long userId, Long translationId);

  /**
   * Método que permite obtener las últimas noticias con los campos seleccionados.
   *
   * @return Lista de las últimas noticias con los campos seleccionados.
   */
  List<NewsDTO> getLatestNewsWithSelectedFields(Long translationId);

  /**
   * Edita una noticia.
   *
   * @param id ID de la noticia a editar.
   * @param newsRequest Noticia a editar.
   * @param file Archivo de imagen.
   * @return La noticia editada.
   */
  News editNews(Long id, News newsRequest, MultipartFile file, Long gameId, Long translationId);

  List<NewsAdminDTO> findNewsByTitle(String title);

  News getById(Long id);
}
