package com.winningstation.controller;

import com.winningstation.entity.NewsAuthor;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.INewsAuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para news authors.
 *
 * @author David Portillo Hoyos
 */
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
  public NewsAuthor save(@RequestBody NewsAuthor newsAuthor) {
    return newsAuthorService.save(newsAuthor);
  }

  /** Obtener todos los registros */
  @GetMapping
  public List<NewsAuthor> findAll() {
    return newsAuthorService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  public List<NewsAuthor> findByName(@PathVariable String name) {
    return newsAuthorService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  public NewsAuthor update(@PathVariable Long id, @RequestBody NewsAuthor request) {
    return newsAuthorService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    newsAuthorService.delete(id);
  }
}
