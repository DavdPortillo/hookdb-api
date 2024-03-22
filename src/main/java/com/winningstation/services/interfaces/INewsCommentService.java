package com.winningstation.services.interfaces;

import com.winningstation.entity.NewsComment;

import java.util.List;

/**
 * Interface que define los métodos que debe implementar la clase NewsComment.
 *
 * @author David Portillo Hoyos
 */
public interface INewsCommentService {

  /**
   * Método que permite obtener un comentario por su ID.
   *
   * @param id ID del comentario.
   * @return El comentario con el ID especificado.
   */
  NewsComment findById(Long id);

  /**
   * Método que permite guardar un comentario.
   *
   * @param newsComment Comentario a guardar.
   * @return El comentario guardado.
   */
  NewsComment save(NewsComment newsComment, Long newsId, Long userId);

  /**
   * Método que permite eliminar un comentario.
   *
   * @param id ID del comentario a eliminar.
   */
  void delete(Long id);

  /**
   * Método que permite obtener todos los registros.
   *
   * @return Lista con todas los registros.
   */
  List<NewsComment> findAll();

  /**
   * Método que permite actualizar
   *
   * @param id Id a actualizar.
   * @param request Plataforma a actualizar.
   * @return la plataforma actualizada.
   */
  String update(Long id, String request);

  /**
   * Método que permite obtener los comentarios de una noticia.
   *
   * @param newsId ID de la noticia.
   * @return Lista con los comentarios de la noticia.
   */
  List<NewsComment> findNewsCommentByNewsId(Long newsId);
}
