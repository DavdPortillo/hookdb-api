package com.winningstation.controller;

import com.winningstation.entity.NewsAuthor;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.INewsAuthorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para news authors.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "News Author Controller", description = "Operaciones para los autores de noticias")
@RestController
@RequestMapping("/news-author")
public class NewsAuthorController {

  /** Servicio para los autores de noticias. */
  private final INewsAuthorService newsAuthorService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param newsAuthorService El servicio para los autores de noticias.
   */
  public NewsAuthorController(INewsAuthorService newsAuthorService) {
    this.newsAuthorService = newsAuthorService;
  }

  /**
   * Crear un autor.
   *
   * @param newsAuthor Autor a crear.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo autor de noticias",
      description =
          "Guarda un nuevo autor de noticias basado en la petición proporcionada y devuelve el autor de noticias guardado")
  public NewsAuthor save(@RequestBody NewsAuthor newsAuthor) {
    return newsAuthorService.save(newsAuthor);
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todos los autores de noticias",
      description = "Devuelve una lista de todos los autores de noticias")
  public List<NewsAuthor> findAll() {
    return newsAuthorService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  @Operation(
      summary = "Busca autores de noticias por su nombre",
      description =
          "Busca autores de noticias basado en el nombre proporcionado y devuelve una lista de autores de noticias encontrados")
  public List<NewsAuthor> findByName(@PathVariable String name) {
    return newsAuthorService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un autor de noticias",
      description =
          "Actualiza un autor de noticias basado en el identificador y la petición proporcionados y devuelve el autor de noticias actualizado")
  public NewsAuthor update(@PathVariable Long id, @RequestBody NewsAuthor request) {
    return newsAuthorService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un autor de noticias",
      description = "Elimina un autor de noticias basado en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    newsAuthorService.delete(id);
  }
}
