package com.winninginnovations.controller;

import com.winninginnovations.entity.Game;
import com.winninginnovations.entity.News;
import com.winninginnovations.entity.NewsAuthor;
import com.winninginnovations.services.interfaces.IGameService;
import com.winninginnovations.services.interfaces.INewsAuthorService;
import com.winninginnovations.services.interfaces.INewsCommentService;
import com.winninginnovations.services.interfaces.INewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/**
 * Controlador para news.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/news")
public class NewsController {

  /** Logger para la clase */
  private static final Logger LOGGER = LoggerFactory.getLogger(News.class);

  /** Servicio para los comentarios de noticias. */
  private final INewsService newsService;

  /** Servicio para los autores de noticias. */
  private final INewsAuthorService newsAuthorService;

  /** Servicio para los juegos. */
  private final IGameService gameService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param newsService El servicio para las noticias.
   */
  public NewsController(
      INewsService newsService, INewsAuthorService newsAuthorService, IGameService gameService) {
    this.newsService = newsService;
    this.newsAuthorService = newsAuthorService;
    this.gameService = gameService;
  }

  /**
   * Crear una noticia.
   *
   * @param news Noticia a crear.
   * @return La noticia creada.
   */
  @PostMapping("/{authorId}")
  public News save(
      @RequestBody News news,
      @PathVariable Long authorId,
      @RequestParam(required = false) Long gameId) {
    // Obtén el autor a partir del ID
    NewsAuthor newsAuthor = newsAuthorService.findById(authorId);

    // Asegúrate de que el autor existe
    if (newsAuthor == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El autor no existe");
    }

    // Asigna el autor a la noticia
    news.setNewsAuthor(newsAuthor);

    // Si se proporcionó un ID de juego, obtén el juego y asígnalo a la noticia
    if (gameId != null) {
      Game game = gameService.findByIdGame(gameId);
      if (game == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El juego no existe");
      }
      news.setGame(game);
    }

    LOGGER.info("Saving news: {}", news);
    return newsService.save(news);
  }

  /** Obtener todas las noticias. */
  @GetMapping
  public Iterable<News> findAll() {
    LOGGER.info("Finding all news");
    return newsService.findAll();
  }
}
