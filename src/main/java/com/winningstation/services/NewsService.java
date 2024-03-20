package com.winningstation.services;

import com.winningstation.dto.NewsAdminDTO;
import com.winningstation.dto.NewsDTO;
import com.winningstation.entity.Game;
import com.winningstation.entity.News;
import com.winningstation.entity.NewsAuthor;
import com.winningstation.entity.Translation;
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

  /** Servicio para las traducciones. */
  private final TranslateService translateService;

  /**
   * Constructor de la clase.
   *
   * @param newsRepository Repositorio de News.
   */
  public NewsService(
      NewsRepository newsRepository,
      NewsAuthorService newsAuthorService,
      GameService gameService,
      FileStorageService fileStorageService,
      TranslateService translateService) {
    this.newsRepository = newsRepository;
    this.newsAuthorService = newsAuthorService;
    this.gameService = gameService;
    this.fileStorageService = fileStorageService;
    this.translateService = translateService;
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

  public News save(News news, MultipartFile file, Long authorId, Long gameId, Long translationId) {
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

    // Si se proporcionó un ID de traducción, obtén la traducción y asígnala a la noticia
    Translation translation = translateService.findById(translationId);
    if (translation == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La traducción no existe");
    }
    news.setTranslation(translation);
    return newsRepository.save(news);
  }

  @Override
  public void delete(Long id) {
    LOG.info("Deleting news by id: {}", id);
    newsRepository.deleteById(id);
  }

  @Override
  public Iterable<News> findAll(Long translationId) {
    LOG.info("Finding all news with translation id: {}", translationId);
    return newsRepository.findByTranslationId(translationId);
  }

  @Override
  public List<News> findNewsFromFollowedGames(Long userId, Long translationId) {
    LOG.info(
        "Finding news from followed games by user: {} with translation id: {}",
        userId,
        translationId);
    return newsRepository.findNewsFromFollowedGamesAndTranslationId(userId, translationId);
  }

  @Override
  public List<News> getNewsExceptUnfollowedGames(Long userId, Long translationId) {
    LOG.info(
        "Finding news from followed games by user: {} with translation id: {}",
        userId,
        translationId);
    return newsRepository.findNewsExceptUnfollowedGamesAndTranslationId(userId, translationId);
  }

  @Override
  public List<NewsDTO> getLatestNewsWithSelectedFields(Long translationId) {
    Pageable topFifteen = PageRequest.of(0, 15, Sort.by(Sort.Direction.DESC, "date"));
    return newsRepository.findLatestNewsWithSelectedFieldsAndTranslationId(
        topFifteen, translationId);
  }

  @Override
  public News editNews(
      Long id, News newsRequest, MultipartFile file, Long gameId, Long translationId) {
    LOG.info("Editing news: {}", id);
    News news =
        newsRepository
            .findById(id)
            .orElseThrow(() -> new IllegalArgumentException("News not found"));
    if (newsRequest.getHeadline() != null) {
      news.setHeadline(newsRequest.getHeadline());
    }
    if (file != null) {
      String fileDownloadUri = fileStorageService.replaceFileAndGenerateUri(file, news.getImage());
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

    if (translationId != null) {
      Translation translation = translateService.findById(translationId);
      if (translation == null) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La traducción no existe");
      }
      news.setTranslation(translation);
    }

    return newsRepository.save(news);
  }

  public List<NewsAdminDTO> findNewsByTitle(String title) {
    return newsRepository.findNewsByTitleIgnoreCase(title);
  }

  @Override
  public News getById(Long id) {
    return newsRepository.findById(id).orElse(null);
  }
}
