package com.winninginnovations.services;

import com.winninginnovations.entity.Genre;
import com.winninginnovations.repository.GenreRepository;
import com.winninginnovations.services.interfaces.IGenreService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa los métodos que se pueden realizar sobre los géneros de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class GenreService implements IGenreService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(GenreService.class);

  /** Repositorio de Platform. */
  private final GenreRepository genreRepository;

  /**
   * Constructor de la clase.
   *
   * @param genreRepository Repositorio de Platform.
   */
  public GenreService(GenreRepository genreRepository) {
    this.genreRepository = genreRepository;
  }

  /**
   * @param genre Género de juego a guardar.
   */
  @Override
  public Genre save(Genre genre) {
    LOG.info("Saving platform: {}", genre);
    genreRepository.save(genre);
    return genre;
  }
}
