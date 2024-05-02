package com.winningstation.controller;

import com.winningstation.dto.NewsAdminDTO;
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
import org.springframework.http.ResponseEntity;
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
  @PostMapping("author/{authorId}/language/{translationId}")
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Crea una noticia",
      description =
          "Crea una noticia basada en la petición proporcionada y devuelve la noticia creada")
  public News save(
      @ModelAttribute News news,
      @RequestPart("file") MultipartFile file,
      @PathVariable Long authorId,
      @RequestParam(required = false) Long gameId,
      @PathVariable Long translationId) {

    return newsService.save(news, file, authorId, gameId, translationId);
  }

  /** Obtener todas las noticias. */
  @GetMapping("/all/language/{translationId}")
  @Operation(
      summary = "Obtiene todas las noticias",
      description = "Devuelve una lista de todas las noticias")
  public Iterable<News> findAll(@PathVariable Long translationId) {
    return newsService.findAll(translationId);
  }

  @PreAuthorize("#id == authentication.principal.id")
  @GetMapping("/user/{id}/language/{translationId}/followedGames")
  @Operation(
      summary = "Encuentra noticias de juegos seguidos",
      description =
          "Devuelve una lista de noticias de juegos seguidos basado en el identificador de usuario proporcionado")
  public List<News> findNewsFromFollowedGames(
      @PathVariable Long id, @PathVariable Long translationId) {
    return newsService.findNewsFromFollowedGames(id, translationId);
  }

  @PreAuthorize("#id == authentication.principal.id")
  @GetMapping("/user/{id}/language/{translationId}/exceptUnfollowedGames")
  @Operation(
      summary = "Obtiene noticias excepto juegos no seguidos",
      description =
          "Devuelve una lista de noticias excepto juegos no seguidos basado en el identificador de usuario proporcionado")
  public List<News> getNewsExceptUnfollowedGames(
      @PathVariable Long id, @PathVariable Long translationId) {
    return newsService.getNewsExceptUnfollowedGames(id, translationId);
  }

  @GetMapping("/main/language/{translationId}")
  @Operation(
      summary = "Obtiene las últimas noticias con campos seleccionados",
      description = "Devuelve una lista de las últimas noticias con campos seleccionados")
  public List<NewsDTO> getLatestNewsWithSelectedFields(@PathVariable Long translationId) {
    return newsService.getLatestNewsWithSelectedFields(translationId);
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
   * @param file Archivo de la noticia.
   * @return La noticia editada.
   */
  @PutMapping("{newsId}")
  @ResponseStatus(HttpStatus.OK)
  @Operation(
      summary = "Edita una noticia",
      description =
          "Edita una noticia basada en el identificador y la petición proporcionados y devuelve la noticia editada")
  public News edit(
      @ModelAttribute News news,
      @RequestPart(value = "file", required = false) MultipartFile file,
      @PathVariable Long newsId,
      @RequestParam(required = false) Long gameId,
      @RequestParam(required = false) Long translationId) {

    return newsService.editNews(newsId, news, file, gameId, translationId);
  }

  @GetMapping("/search-admin/{title}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @Operation(
      summary = "Encuentra noticias por título",
      description = "Devuelve una lista de noticias basada en el título proporcionado")
  public ResponseEntity<List<NewsAdminDTO>> findNewsByTitle(@PathVariable String title) {
    List<NewsAdminDTO> news = newsService.findNewsByTitle(title);
    return ResponseEntity.ok(news);
  }

  @GetMapping({"/{id}"})
  @Operation(
      summary = "Obtiene una noticia por su ID",
      description = "Devuelve una noticia basada en el identificador proporcionado")
  public ResponseEntity<News> getNewsById(@PathVariable Long id) {
    return ResponseEntity.ok(newsService.findById(id));
  }

  @GetMapping("/getAllNews")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  @Operation(
      summary = "Obtiene todas las noticias",
      description = "Devuelve una lista de todas las noticias")
  public ResponseEntity<Iterable<News>> getAllNews() {
    return ResponseEntity.ok(newsService.getAllNews());
  }
}
