package com.winningstation.controller;

import com.winningstation.entity.Genre;
import com.winningstation.services.interfaces.IGenreService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que controla las peticiones relacionadas con los géneros de los juegos.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/genre")
public class GenreController {

  /** Servicio para las plataformas. */
  private final IGenreService genreService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param genreService Servicio para las plataformas.
   */
  public GenreController(IGenreService genreService) {
    this.genreService = genreService;
  }

  /**
   * Guarda un nuevo género.
   *
   * @param genre El género a guardar.
   */
  @PostMapping
  public Genre saveGenre(@RequestBody Genre genre) {
    genreService.save(genre);
    return genre;
  }
}
