package com.winninginnovations.services;

import com.winninginnovations.entity.Platform;
import com.winninginnovations.repository.PlatformRepository;
import com.winninginnovations.request.GameRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.winninginnovations.entity.Game;
import com.winninginnovations.repository.GameRepository;
import com.winninginnovations.services.interfaces.IGameService;

import jakarta.transaction.Transactional;

import java.util.List;

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
     * Repositorio de plataforma
     */
    private final PlatformRepository platformRepository;

    /**
     * Constructor de la clase.
     *
     * @param gameRepository Repositorio de Game.
     */
    public GameService(GameRepository gameRepository, PlatformRepository platformRepository) {
        this.gameRepository = gameRepository;
        this.platformRepository = platformRepository;
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
    public Game save(Game game, List<Long> platformsIds) {
        if (platformsIds != null && !platformsIds.isEmpty()) {
            List<Platform> platforms = platformRepository.findAllById(platformsIds);
            game.setPlatforms(platforms);
        }
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
