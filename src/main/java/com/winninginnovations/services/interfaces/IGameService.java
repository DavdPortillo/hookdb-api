package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.Game;

import java.util.List;

/**
 * Interface que define los métodos que debe implementar la clase Game.
 *
 * @author David Portillo Hoyos
 */
public interface IGameService {

    /**
     * Método que permite obtener un juego por su ID.
     *
     * @param id ID del juego.
     * @return El juego con el ID especificado.
     */
    Game findById(Long id);

    /**
     * Método que permite guardar un juego.
     *
     * @param game         Juego a guardar.
     * @param platformsIds Lista de IDs de las plataformas.
     * @return El juego guardado.
     */
    Game save(Game game, List<Long> platformsIds);

    /**
     * Método que permite eliminar un juego.
     *
     * @param id ID del juego a eliminar.
     */
    void delete(Long id);

    /**
     * Método que permite obtener todos los juegos.
     *
     * @return Lista de todos los juegos.
     */
    Iterable<Game> findAll();


}
