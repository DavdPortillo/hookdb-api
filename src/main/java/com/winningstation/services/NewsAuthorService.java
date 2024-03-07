package com.winningstation.services;

import com.winningstation.entity.NewsAuthor;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.repository.NewsAuthorRepository;
import com.winningstation.services.interfaces.INewsAuthorService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase que implementa la interfaz INewsAuthor.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class NewsAuthorService implements INewsAuthorService {

  /** Logger. */
  private static final Logger LOG = LoggerFactory.getLogger(NewsAuthorService.class);

  /** Repositorio de NewsAuthor. */
  private final NewsAuthorRepository newsAuthorRepository;

  /**
   * Constructor de la clase.
   *
   * @param newsAuthorRepository Repositorio de NewsAuthor.
   */
  public NewsAuthorService(NewsAuthorRepository newsAuthorRepository) {
    this.newsAuthorRepository = newsAuthorRepository;
  }

  @Override
  public NewsAuthor findById(Long id) {
    LOG.info("Finding news author by id: {}", id);
    NewsAuthor newsAuthor = newsAuthorRepository.findById(id).orElse(null);
    if (newsAuthor == null) {
      LOG.info("News author not found");
    }
    return newsAuthor;
  }

  @Override
  public NewsAuthor save(NewsAuthor newsAuthor) {
    LOG.info("Saving news author: {}", newsAuthor);
    return newsAuthorRepository.save(newsAuthor);
  }

  @Override
  public void delete(Long id) {
    LOG.info("Deleting news author by id: {}", id);
    if (newsAuthorRepository.findById(id).isPresent()) {
      newsAuthorRepository.deleteById(id);
    } else {
      throw new RuntimeException("News author not found");
    }
  }

  @Override
  public List<NewsAuthor> findAll() {
    LOG.info("Finding all news authors");
    return newsAuthorRepository.findAll();
  }

  @Override
  public NewsAuthor update(Long id, NewsAuthor request) {
    LOG.info("Updating news author by id: {}", id);
    NewsAuthor newsAuthor = findById(id);
    if (newsAuthor == null) {
      throw new RuntimeException("News author not found");
    }
    if (request.getName() != null) {
      newsAuthor.setName(request.getName());
    }
    if (request.getSurname() != null) {
      newsAuthor.setSurname(request.getSurname());
    }
    if (request.getImage() != null) {
      newsAuthor.setImage(request.getImage());
    }
    if (request.getAlt() != null) {
      newsAuthor.setAlt(request.getAlt());
    }
    return newsAuthorRepository.save(newsAuthor);
  }

  @Override
  public List<NewsAuthor> findByName(String name) {
    LOG.info("Finding news author by name: {}", name);
    return newsAuthorRepository.findByNameContaining(name);
  }
}
