package com.winningstation.services;

import com.winningstation.entity.DLC;
import com.winningstation.entity.Game;
import com.winningstation.repository.DLCRepository;
import com.winningstation.repository.GameRepository;
import com.winningstation.services.interfaces.IDLCService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de dlc.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class DLCService implements IDLCService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(DLCService.class);

  /** Repositorio de dlc. */
  private final DLCRepository dlcRepository;

  /** Repositorio de game. */
  private final GameRepository gameRepository;

  /**
   * Constructor de la clase.
   *
   * @param dlcRepository Repositorio de dlc.
   */
  public DLCService(DLCRepository dlcRepository, GameRepository gameRepository) {
    this.dlcRepository = dlcRepository;
    this.gameRepository = gameRepository;
  }

  @Override
  public DLC save(DLC dlc, Long gameId) {
    LOG.info("Saving DLC: {}", dlc);
    Game game =
        gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
    dlc.setGame(game);
    return dlcRepository.save(dlc);
  }

  @Override
  public void delete(Long dlcId) {
    LOG.info("Deleting DLC with id: {}", dlcId);

    if (dlcRepository.existsById(dlcId)) {
      dlcRepository.deleteById(dlcId);
      LOG.info("DLC with id: {} has been deleted", dlcId);
    } else {
      LOG.info("DLC with id: {} does not exist", dlcId);
      throw new RuntimeException("DLC not found");
    }
  }

  @Override
  public DLC getById(Long dlcId) {
    return dlcRepository.findById(dlcId).orElseThrow(() -> new RuntimeException("DLC not found"));
  }

  @Override
  public DLC update(Long id, DLC dlcRequest) {

    LOG.info("Updating DLC with id: {}", id);

    // Busca el DLC en la base de datos
    DLC dlc = dlcRepository.findById(id).orElseThrow(() -> new RuntimeException("DLC not found"));

    // Actualiza solo el campo que deseas cambiar
    if (dlcRequest.getName() != null) {
      dlc.setName(dlcRequest.getName());
    }

    if (dlcRequest.getDate() != null) {
      dlc.setDate(dlcRequest.getDate());
    }

    if (dlcRequest.getSinopsis() != null) {
      dlc.setSinopsis(dlcRequest.getSinopsis());
    }

    if (dlcRequest.getGame() != null) {
      dlc.setGame(dlcRequest.getGame());
    }

    // Guarda el DLC actualizado en la base de datos
    return dlcRepository.save(dlc);
  }

  @Override
  public List<DLC> getByGameId(Long gameId) {
    LOG.info("Getting DLCs by game id: {}", gameId);
    if (gameRepository.existsById(gameId)) {
      return dlcRepository.findByGameId(gameId);
    } else {
      LOG.info("Game with id: {} does not exist", gameId);
      throw new RuntimeException("Game not found");
    }
  }

  @Override
  public List<DLC> findByNameContaining(String name) {
    return dlcRepository.findByNameContaining(name);
  }
}
