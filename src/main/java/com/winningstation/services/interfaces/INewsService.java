package com.winningstation.services.interfaces;

import com.winningstation.entity.News;

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


}
