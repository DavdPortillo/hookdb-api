package com.winningstation.controller;

import com.winningstation.entity.NewsComment;

import com.winningstation.services.interfaces.INewsCommentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para news comments.
 *
 * @author David Portillo Hoyos
 */
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
  public NewsComment createComment(
      @PathVariable Long newsId, @PathVariable Long userId, @RequestBody NewsComment newsComment) {
    return newsCommentService.save(newsComment, newsId, userId);
  }

  /** Obtener todos los registros */
  @GetMapping
  public List<NewsComment> findAll() {
    return newsCommentService.findAll();
  }

  /** Borra un comentario */
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) {
    newsCommentService.delete(id);
  }

  /** Actualizar un comentario */
  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody String newsComment) {
    return newsCommentService.update(id, newsComment);
  }
}
