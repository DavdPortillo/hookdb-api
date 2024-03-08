package com.winningstation.controller;

import com.winningstation.entity.NewsComment;

import com.winningstation.services.interfaces.INewsCommentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para news comments.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "News Comment Controller", description = "Operaciones para los comentarios de noticias")
@RestController
@RequestMapping("/news-comment")
public class NewsCommentController {

  /** Servicio para los comentarios de noticias. */
  private final INewsCommentService newsCommentService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param newsCommentService El servicio para los comentarios de noticias.
   */
  public NewsCommentController(INewsCommentService newsCommentService) {
    this.newsCommentService = newsCommentService;
  }

  @PostMapping("/{newsId}/{userId}")
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Crea un comentario de noticias",
      description =
          "Crea un comentario de noticias basado en la petición proporcionada y devuelve el comentario de noticias creado")
  public NewsComment createComment(
      @PathVariable Long newsId, @PathVariable Long userId, @RequestBody NewsComment newsComment) {
    return newsCommentService.save(newsComment, newsId, userId);
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todos los comentarios de noticias",
      description = "Devuelve una lista de todos los comentarios de noticias")
  public List<NewsComment> findAll() {
    return newsCommentService.findAll();
  }

  /** Borra un comentario */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Borra un comentario de noticias",
      description = "Borra un comentario de noticias basado en el identificador proporcionado")
  public void delete(@PathVariable Long id) {
    newsCommentService.delete(id);
  }

  /** Actualizar un comentario */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un comentario de noticias",
      description =
          "Actualiza un comentario de noticias basado en el identificador y la petición proporcionados y devuelve el comentario actualizado")
  public String update(@PathVariable Long id, @RequestBody String newsComment) {
    return newsCommentService.update(id, newsComment);
  }
}
