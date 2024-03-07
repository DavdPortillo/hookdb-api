package com.winningstation.controller;

import com.winningstation.entity.Genre;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.IGenreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  /** Obtener todos los registros */
  @GetMapping
  public List<Genre> findAll() {
    return genreService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  public List<Genre> findByName(@PathVariable String name) {
    return genreService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return genreService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    genreService.deleteById(id);
  }
}
