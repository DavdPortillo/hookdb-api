package com.winningstation.services;

import com.winningstation.entity.Genre;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.repository.GenreRepository;
import com.winningstation.services.interfaces.IGenreService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

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
    LOG.info("Saving genre: {}", genre);
    genreRepository.save(genre);
    return genre;
  }

  @Override
  public Genre findById(Long id) {
    LOG.info("Obteniendo genre por id {}", id);
    return genreRepository.findById(id).orElse(null);
  }

  @Override
  public List<Genre> findAll() {
    LOG.info("Obteniendo todas los géneros de juegos.");
    return genreRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    LOG.info("Eliminando genre por id {}", id);
    genreRepository.deleteById(id);
  }

  @Override
  public String update(Long id, String request) {
    LOG.info("Actualizando genre por id {}", id);
    Genre genre = genreRepository.findById(id).orElse(null);
    if (genre != null) {
      genre.setName(request);
      genreRepository.save(genre);
      return request;
    } else {
      throw new RuntimeException("No se encontró el género con el id " + id);
    }
  }

  @Override
  public List<Genre> findByName(String name) {
    LOG.info("Obteniendo géneros por nombre {}", name);
    return genreRepository.findByNameContaining(name);
  }
}
