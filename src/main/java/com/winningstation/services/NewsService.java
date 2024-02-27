package com.winningstation.services;

import com.winningstation.entity.News;
import com.winningstation.repository.NewsRepository;
import com.winningstation.services.interfaces.INewsService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

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

  /**
   * Constructor de la clase.
   *
   * @param newsRepository Repositorio de News.
   */
  public NewsService(NewsRepository newsRepository) {
    this.newsRepository = newsRepository;
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

  @Override
  public News save(News news) {
    LOG.info("Saving news: {}", news);

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
}
