package com.winningstation.services;

import com.winningstation.entity.*;
import com.winningstation.repository.NewsCommentRepository;
import com.winningstation.repository.NewsRepository;
import com.winningstation.repository.UserRepository;
import com.winningstation.services.interfaces.INewsCommentService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase que implementa la interfaz INewsCommentService.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class NewsCommentService implements INewsCommentService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(NewsCommentService.class);

  /** Repositorio de NewsComment. */
  private final NewsCommentRepository newsCommentRepository;

  /** Repositorio de News. */
  private final NewsRepository newsRepository;

  /** Repositorio de User. */
  private final UserRepository userRepository;

  /** */

  /**
   * Constructor de la clase.
   *
   * @param newsCommentRepository Repositorio de Game.
   */
  public NewsCommentService(
      NewsCommentRepository newsCommentRepository,
      NewsRepository newsRepository,
      UserRepository userRepository) {
    this.newsCommentRepository = newsCommentRepository;
    this.newsRepository = newsRepository;
    this.userRepository = userRepository;
  }

  @Override
  public NewsComment findById(Long id) {
    LOG.info("Finding comment by id: {}", id);
    NewsComment newsComment = newsCommentRepository.findById(id).orElse(null);
    if (newsComment == null) {
      LOG.info("Comment not found by id {}", id);
    }
    return newsComment;
  }

  @Override
  public NewsComment save(NewsComment newsComment, Long newsId, Long userId) {
    News news =
        newsRepository
            .findById(newsId)
            .orElseThrow(() -> new IllegalArgumentException("News not found"));
    User user =
        userRepository
            .findById(userId)
            .orElseThrow(() -> new IllegalArgumentException("User not found"));

    newsComment.setNews(news);
    newsComment.setUser(user);

    return newsCommentRepository.save(newsComment);
  }

  @Override
  public void delete(Long id) {
    LOG.info("Deleting game by id: {}", id);
    newsCommentRepository.deleteById(id);
  }

  @Override
  public List<NewsComment> findAll() {
    LOG.info("Finding all comments");
    return newsCommentRepository.findAll();
  }

  @Override
  public String update(Long id, String request) {
    LOG.info("Updating news comment by id {}", id);
    NewsComment newsComment = findById(id);
    if (newsComment != null) {
      newsComment.setContent(request);
      newsCommentRepository.save(newsComment);
      return request;
    } else {
      throw new RuntimeException("Platform not found");
    }
  }

  @Override
  public List<NewsComment> findNewsCommentByNewsId(Long newsId) {
    LOG.info("Finding comments by news id: {}", newsId);
    return newsCommentRepository.findNewsCommentByNewsId(newsId);
  }
}
