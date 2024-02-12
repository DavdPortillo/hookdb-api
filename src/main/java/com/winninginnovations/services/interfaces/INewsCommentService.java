package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.NewsComment;

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


}
