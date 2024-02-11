package com.winninginnovations.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.winninginnovations.entity.Game;
import com.winninginnovations.services.interfaces.IGameService;

/**
 * Controlador para el juego.
 * 
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/game")
public class GameController {
	
	
	/**
	 * Logger para la clase
	 */
	private static final Logger LOG = LoggerFactory.getLogger(GameController.class);

	
	/**
	 * Servicio para los juegos.
	 */
	private final IGameService gameService;

	/**
	 * Constructor para la inyección de dependencias.
	 * 
	 * @param gameService Servicio para los juegos.
	 */
	public GameController(IGameService gameService) {
		this.gameService = gameService;
	}

	/**
	 * Crea un nuevo juego.
	 * 
	 * @param game El juego a crear.
	 * @return El juego creado.
	 */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
	public Game createGame(@RequestBody Game game) {
		LOG.info("Creating game: {}", game);
		return gameService.save(game);
	}
    
    /**
	 * Encuentra todos los juegos.
	 * 
	 * @return Lista de juegos.
	 */
    @GetMapping
    public Iterable<Game> findAll() {
    	LOG.info("Finding all games");
    	return gameService.findAll();
    }
    


}
