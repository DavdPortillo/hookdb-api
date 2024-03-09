package com.winningstation.controller;

import com.winningstation.dto.NewsDTO;
import com.winningstation.entity.Game;
import com.winningstation.entity.News;
import com.winningstation.entity.NewsAuthor;
import com.winningstation.services.interfaces.IGameService;
import com.winningstation.services.interfaces.INewsAuthorService;
import com.winningstation.services.interfaces.INewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Controlador para news.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "News Controller", description = "Operaciones para las noticias")
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
  @PostMapping("author/{authorId}")
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Crea una noticia",
      description =
          "Crea una noticia basada en la petición proporcionada y devuelve la noticia creada")
  public News save(
          @RequestPart("headline") String headline,
          @RequestPart("alt") String alt,
          @RequestPart("content") String content,
          @RequestPart("file") MultipartFile file,
          @PathVariable Long authorId,
          @RequestParam(required = false) Long gameId) {

    News news = new News();
    news.setHeadline(headline);
    news.setAlt(alt);
    news.setContent(content);

    return newsService.save(news, file, authorId, gameId);
  }

  /** Obtener todas las noticias. */
  @GetMapping("/all")
  @Operation(
      summary = "Obtiene todas las noticias",
      description = "Devuelve una lista de todas las noticias")
  public Iterable<News> findAll() {
    return newsService.findAll();
  }

  @PreAuthorize("#id == authentication.principal.id")
  @GetMapping("/user/{id}")
  @Operation(
      summary = "Encuentra noticias de juegos seguidos",
      description =
          "Devuelve una lista de noticias de juegos seguidos basado en el identificador de usuario proporcionado")
  public List<News> findNewsFromFollowedGames(@PathVariable Long id) {
    return newsService.findNewsFromFollowedGames(id);
  }

  @PreAuthorize("#id == authentication.principal.id")
  @GetMapping("/user/{id}/exceptUnfollowedGames")
  @Operation(
      summary = "Obtiene noticias excepto juegos no seguidos",
      description =
          "Devuelve una lista de noticias excepto juegos no seguidos basado en el identificador de usuario proporcionado")
  public List<News> getNewsExceptUnfollowedGames(@PathVariable Long id) {
    return newsService.getNewsExceptUnfollowedGames(id);
  }

  @GetMapping("/main")
  @Operation(
      summary = "Obtiene las últimas noticias con campos seleccionados",
      description = "Devuelve una lista de las últimas noticias con campos seleccionados")
  public List<NewsDTO> getLatestNewsWithSelectedFields() {
    return newsService.getLatestNewsWithSelectedFields();
  }

  /**
   * Borra una noticia.
   *
   * @param id ID de la noticia a borrar.
   */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Borra una noticia",
      description = "Borra una noticia basada en el identificador proporcionado")
  public void delete(@PathVariable Long id) {
    newsService.delete(id);
  }

  /**
   * Edita una noticia.
   *
   * @param news Noticia a editar.
   * @param id ID de la noticia a editar.
   * @return La noticia editada.
   */
  @PutMapping("/{id}")
  @Operation(
      summary = "Edita una noticia",
      description =
          "Edita una noticia basada en el identificador y la petición proporcionados y devuelve la noticia editada")
  public News update(@PathVariable Long id, @RequestBody News news) {
    return newsService.editNews(id, news);
  }
}
