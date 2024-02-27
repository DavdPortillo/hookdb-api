package com.winningstation.controller;

import com.winningstation.entity.Game;
import com.winningstation.entity.News;
import com.winningstation.entity.NewsAuthor;
import com.winningstation.services.interfaces.IGameService;
import com.winningstation.services.interfaces.INewsAuthorService;
import com.winningstation.services.interfaces.INewsService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controlador para news.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/news")
public class NewsController {

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

    return newsService.save(news);
  }

  /** Obtener todas las noticias. */
  @GetMapping
  public Iterable<News> findAll() {
    return newsService.findAll();
  }

  @GetMapping("/user/{id}")
  public List<News> findNewsFromFollowedGames(@PathVariable Long id) {
    return newsService.findNewsFromFollowedGames(id);
  }

  @GetMapping("/user/{id}/exceptUnfollowedGames")
  public List<News> getNewsExceptUnfollowedGames(@PathVariable Long id) {
    return newsService.getNewsExceptUnfollowedGames(id);
  }
}
