package com.winningstation.services;

import com.winningstation.entity.NumberPlayer;
import com.winningstation.repository.NumberPlayerRepository;
import com.winningstation.services.interfaces.INumberPlayerService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Servicio de número de jugadores.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class NumberPlayerService implements INumberPlayerService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(NumberPlayerService.class);

  /** Repositorio de número de jugadores. */
  private final NumberPlayerRepository numberPlayerRepository;

  /**
   * Constructor de la clase.
   *
   * @param numberPlayerRepository Repositorio de número de jugadores.
   */
  public NumberPlayerService(NumberPlayerRepository numberPlayerRepository) {
    this.numberPlayerRepository = numberPlayerRepository;
  }

  /**
   * Guarda un número de jugadores.
   *
   * @param numberPlayer Número de jugadores a guardar.
   * @return Número de jugadores guardado.
   */
  @Override
  public NumberPlayer save(NumberPlayer numberPlayer) {
    LOG.info("Saving numberPlayer: {}", numberPlayer);
    numberPlayerRepository.save(numberPlayer);
    return numberPlayer;
  }

  @Override
  public void delete(NumberPlayer numberPlayer) {
    LOG.info("Deleting numberPlayer: {}", numberPlayer);
    numberPlayerRepository.delete(numberPlayer);
  }

  @Override
  public NumberPlayer getById(Long id) {
    return numberPlayerRepository.findById(id).orElse(null);
  }

  @Override
  public Integer update(Long id, Integer numberPlayerRequest) {
    NumberPlayer numberPlayer = numberPlayerRepository.findById(id).orElse(null);
    if (numberPlayer == null) {
      return numberPlayerRequest;
    }
    numberPlayer.setNumberPlayers(numberPlayerRequest);
    numberPlayerRepository.save(numberPlayer);
    return numberPlayerRequest;
  }

  @Override
  public NumberPlayer getByNumberPlayers(Integer numberPlayers) {
    return numberPlayerRepository.findByNumberPlayers(numberPlayers);
  }

  @Override
  public List<NumberPlayer> findAll() {
    return numberPlayerRepository.findAll();
  }
}
