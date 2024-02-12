package com.winninginnovations.services;

import com.winninginnovations.entity.NewsAuthor;
import com.winninginnovations.repository.NewsAuthorRepository;
import com.winninginnovations.services.interfaces.INewsAuthorService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz INewsAuthor.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class NewsAuthorService implements INewsAuthorService {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(NewsAuthorService.class);

    /**
     * Repositorio de NewsAuthor.
     */
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
        newsAuthorRepository.deleteById(id);
    }
}
