package com.winningstation.services.interfaces;

import com.winningstation.entity.Genre;


/**
 * Interfaz que define los métodos que se pueden realizar sobre los géneros de los juegos.
 *
 * @author David Portillo Hoyos
 */
public interface IGenreService {


    /**
     * Método que permite guardar un género de juego.
     *
     * @param genre Género de juego a guardar.
     * @return El género de juego guardado.
     */
    Genre save(Genre genre);

}
