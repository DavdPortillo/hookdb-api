package com.winningstation.controller;

import com.winningstation.entity.Genre;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.IGenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que controla las peticiones relacionadas con los géneros de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Genre Controller", description = "Operaciones para los géneros de los juegos")
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
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo género",
      description =
          "Guarda un nuevo género basado en la petición proporcionada y devuelve el género guardado")
  public Genre saveGenre(@RequestBody Genre genre) {
    genreService.save(genre);
    return genre;
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todos los géneros",
      description = "Devuelve una lista de todos los géneros")
  public List<Genre> findAll() {
    return genreService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("name/{name}")
  @Operation(
      summary = "Busca géneros por su nombre",
      description =
          "Busca géneros basado en el nombre proporcionado y devuelve una lista de géneros encontrados")
  public List<Genre> findByName(@PathVariable String name) {
    return genreService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un género",
      description =
          "Actualiza un género basado en el identificador y la petición proporcionados y devuelve el nombre actualizado")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return genreService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un género",
      description = "Elimina un género basado en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    genreService.deleteById(id);
  }

  @GetMapping
  @Operation(
      summary = "Obtiene género por id",
      description = "Devuelve un género basado en el identificador proporcionado")
  public Genre findById(@PathVariable Long id) {
    return genreService.findById(id);
  }
}
