package com.winninginnovations.services.interfaces;

import com.winninginnovations.entity.Game;

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
	public Game findById(Long id);
	
	/**
	 * Método que permite guardar un juego.
	 * 
	 * @param game Juego a guardar.
	 * @return El juego guardado.
	 */
	public Game save(Game game);
	
	/**
	 * Método que permite eliminar un juego.
	 * 
	 * @param id ID del juego a eliminar.
	 */
	public void delete(Long id);
	
	/**
	 * Método que permite obtener todos los juegos.
	 * 
	 * @return Lista de todos los juegos.
	 */
	public Iterable<Game> findAll();
	
	

}
