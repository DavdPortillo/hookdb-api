package com.winningstation.services;

import com.winningstation.dto.DLCDto;
import com.winningstation.entity.DLC;
import com.winningstation.entity.Game;
import com.winningstation.repository.DLCRepository;
import com.winningstation.repository.GameRepository;
import com.winningstation.services.interfaces.IDLCService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

  private final FileStorageService fileStorageService;

  /**
   * Constructor de la clase.
   *
   * @param dlcRepository Repositorio de dlc.
   */
  public DLCService(
      DLCRepository dlcRepository,
      GameRepository gameRepository,
      FileStorageService fileStorageService) {
    this.dlcRepository = dlcRepository;
    this.gameRepository = gameRepository;
    this.fileStorageService = fileStorageService;
  }

  @Override
  public DLC save(DLC dlc, Long gameId, MultipartFile file) {
    LOG.info("Saving DLC: {}", dlc);
    Game game =
        gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Game not found"));
    dlc.setGame(game);
    String fileDownloadUri = fileStorageService.storeFileAndGenerateUri(file);
    dlc.setImage(fileDownloadUri);
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
  public DLCDto update(Long id, DLC dlcRequest, MultipartFile file) {

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
      Game game = gameRepository.findById(dlcRequest.getGame().getId())
              .orElseThrow(() -> new RuntimeException("Game not found"));
      dlc.setGame(game);
    }

    if (file != null && !file.isEmpty()) {
      String fileDownloadUri = fileStorageService.replaceFileAndGenerateUri(file, dlc.getImage());
      dlc.setImage(fileDownloadUri);
    }

    if (dlcRequest.getAlt() != null) {
      dlc.setAlt(dlcRequest.getAlt());
    }

    // Guarda el DLC actualizado en la base de datos
    DLC updatedDLC = dlcRepository.save(dlc);

    // Crea un nuevo DLCDto con los datos del DLC actualizado
    DLCDto dlcDto = new DLCDto(
            updatedDLC.getId(),
            updatedDLC.getName(),
            updatedDLC.getDate(),
            updatedDLC.getSinopsis(),
            updatedDLC.getImage(),
            updatedDLC.getAlt(),
            updatedDLC.getGame().getId(),
            updatedDLC.getGame().getTitle()
    );

    // Devuelve el DLCDto
    return dlcDto;
  }

  @Override
  public List<DLCDto> getByGameId(Long gameId) {
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

    @Override
    public List<DLC> getAll() {
        return dlcRepository.findAll();
    }
}
