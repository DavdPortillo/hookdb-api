package com.winningstation.services.interfaces;

import com.winningstation.entity.Developer;

/**
 * Interfaz que define los métodos que se pueden realizar sobre los desarrolladores de los juegos.
 *
 * @author David Portillo Hoyos
 */
public interface IDeveloperService {

    /**
     * Método que permite guardar un desarrollador de juego.
     *
     * @param developer Desarrollador de juego a guardar.
     * @return El desarrollador de juego guardado.
     */
    Developer save(Developer developer);
}
