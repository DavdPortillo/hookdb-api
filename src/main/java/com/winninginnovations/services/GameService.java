package com.winninginnovations.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.winninginnovations.entity.Game;
import com.winninginnovations.repository.GameRepository;
import com.winninginnovations.services.interfaces.IGameService;

import jakarta.transaction.Transactional;

/**
 * Implementación de los métodos de la interfaz IGameService.
 * 
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class GameService implements IGameService {

	/**
	 * Logger.
	 */
	private static final Logger LOG = LoggerFactory.getLogger(GameService.class);

	/**
	 * Repositorio de Game.
	 */
	private final GameRepository gameRepository;

	/**
	 * Constructor de la clase.
	 * 
	 * @param gameRepository Repositorio de Game.
	 */
	public GameService(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}

	@Override
	public Game findById(Long id) {
		LOG.info("Finding game by id: {}", id);
		Game game = gameRepository.findById(id).orElse(null);
		if (game == null) {
			LOG.info("Game not found");
		}
		return game;

	}

	@Override
	public Game save(Game game) {
		LOG.info("Saving game: {}", game);
		return gameRepository.save(game);
	}

	@Override
	public void delete(Long id) {
		LOG.info("Deleting game by id: {}", id);
		gameRepository.deleteById(id);
	}

	@Override
	public Iterable<Game> findAll() {
		LOG.info("Finding all games");
		return gameRepository.findAll();
	}
}
