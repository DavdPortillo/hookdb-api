package com.winningstation.services;

import com.winningstation.dto.NewsDTO;
import com.winningstation.entity.Game;
import com.winningstation.entity.News;
import com.winningstation.entity.NewsAuthor;
import com.winningstation.repository.NewsRepository;
import com.winningstation.services.interfaces.INewsService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

/**
 * Clase que implementa la interfaz INewsService.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class NewsService implements INewsService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(NewsService.class);

  /** Repositorio de News. */
  private final NewsRepository newsRepository;

  /** Servicio para los autores de noticias. */
  private final NewsAuthorService newsAuthorService;

  /** Servicio para los juegos. */
  private final GameService gameService;

  private final FileStorageService fileStorageService;

  /**
   * Constructor de la clase.
   *
   * @param newsRepository Repositorio de News.
   */
  public NewsService(
      NewsRepository newsRepository,
      NewsAuthorService newsAuthorService,
      GameService gameService,
      FileStorageService fileStorageService) {
    this.newsRepository = newsRepository;
    this.newsAuthorService = newsAuthorService;
    this.gameService = gameService;
    this.fileStorageService = fileStorageService;
  }

  @Override
  public News findById(Long id) {
    LOG.info("Finding news by id: {}", id);
    News news = newsRepository.findById(id).orElse(null);
    if (news == null) {
      LOG.info("News not found");
    }
    return news;
  }

  public News save(News news, MultipartFile file, Long authorId, Long gameId) {
    LOG.info("Saving news: {}", news);
    NewsAuthor newsAuthor = newsAuthorService.findById(authorId);

    // Asegúrate de que el autor existe
    if (newsAuthor == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El autor no existe");
    }

    // Asigna el autor a la noticia
    news.setNewsAuthor(newsAuthor);

    String fileDownloadUri = fileStorageService.storeFileAndGenerateUri(file);
    // Asigna la URL de la imagen a la noticia
    news.setImage(fileDownloadUri);

    // Si se proporcionó un ID de juego, obtén el juego y asígnalo a la noticia
    if (gameId != null) {
      Game game = gameService.findByIdGame(gameId);
      if (game == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El juego no existe");
      }
      news.setGame(game);
    }
    return newsRepository.save(news);
  }

  @Override
  public void delete(Long id) {
    LOG.info("Deleting news by id: {}", id);
    newsRepository.deleteById(id);
  }

  @Override
  public Iterable<News> findAll() {
    LOG.info("Finding all news");
    return newsRepository.findAll();
  }

  @Override
  public List<News> findNewsFromFollowedGames(Long userId) {
    LOG.info("Finding news from followed games by user: {}", userId);
    return newsRepository.findNewsFromFollowedGames(userId);
  }

  @Override
  public List<News> getNewsExceptUnfollowedGames(Long userId) {
    LOG.info("Finding news from followed games by user: {}", userId);
    return newsRepository.findNewsExceptUnfollowedGames(userId);
  }

  @Override
  public List<NewsDTO> getLatestNewsWithSelectedFields() {
    Pageable topFifteen = PageRequest.of(0, 15, Sort.by(Sort.Direction.DESC, "date"));
    return newsRepository.findLatestNewsWithSelectedFields(topFifteen);
  }

  @Override
  public News editNews(Long id, News newsRequest, MultipartFile file, Long gameId) {
    LOG.info("Editing news: {}", id);
    News news =
        newsRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException("News not found"));
    if (newsRequest.getHeadline() != null) {
      news.setHeadline(newsRequest.getHeadline());
    }
    if (file != null) {
      String fileDownloadUri = fileStorageService.storeFileAndGenerateUri(file);
      news.setImage(fileDownloadUri);
    }
    if (newsRequest.getAlt() != null) {
      news.setAlt(newsRequest.getAlt());
    }
    if (newsRequest.getContent() != null) {
      news.setContent(newsRequest.getContent());
    }
    if (gameId != null) {
      Game game = gameService.findByIdGame(gameId);
      if (game == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El juego no existe");
      }
      news.setGame(game);
    }

    return newsRepository.save(news);
  }
}
