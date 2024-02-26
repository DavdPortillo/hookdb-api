package com.winninginnovations.controller;

import com.winninginnovations.entity.NewsComment;

import com.winninginnovations.services.interfaces.INewsCommentService;

import org.springframework.web.bind.annotation.*;

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
}
