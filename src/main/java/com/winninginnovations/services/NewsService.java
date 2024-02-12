package com.winninginnovations.services;

import com.winninginnovations.entity.News;
import com.winninginnovations.repository.NewsRepository;
import com.winninginnovations.services.interfaces.INewsService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz INewsService.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class NewsService implements INewsService {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(News.class);

    /**
     * Repositorio de News.
     */
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
}