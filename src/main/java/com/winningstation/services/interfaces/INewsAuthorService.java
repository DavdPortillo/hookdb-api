package com.winningstation.services.interfaces;

import com.winningstation.entity.NewsAuthor;

/**
 * Interface que define los métodos que debe implementar la clase NewsAuthor.
 *
 * @author David Portillo Hoyos
 */
public interface INewsAuthorService {

    /**
     * Método que permite obtener un autor por su ID.
     *
     * @param id ID del autor.
     * @return El autor con el ID especificado.
     */
    NewsAuthor findById(Long id);

    /**
     * Método que permite guardar un autor.
     *
     * @param newsAuthor Autor a guardar.
     * @return El autor guardado.
     */
    NewsAuthor save(NewsAuthor newsAuthor);

    /**
     * Método que permite eliminar un autor.
     *
     * @param id id del autor a eliminar.
     */
    void delete(Long id);
}
