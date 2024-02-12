package com.winninginnovations.services;

import com.winninginnovations.entity.News;
import com.winninginnovations.entity.NewsComment;
import com.winninginnovations.entity.User;
import com.winninginnovations.repository.NewsCommentRepository;
import com.winninginnovations.repository.NewsRepository;
import com.winninginnovations.repository.UserRepository;
import com.winninginnovations.services.interfaces.INewsCommentService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Clase que implementa la interfaz INewsCommentService.
 *
 * @author David Portillo Hoyos
 */
@Service
@Transactional
public class NewsCommentService implements INewsCommentService {

    /**
     * Logger.
     */
    private static final Logger LOG = LoggerFactory.getLogger(NewsCommentService.class);

    /**
     * Repositorio de NewsComment.
     */
    private final NewsCommentRepository newsCommentRepository;

    /**
     * Repositorio de News.
     */
    private final NewsRepository newsRepository;

    /**
     * Repositorio de User.
     */
    private final UserRepository userRepository;

    /**
     *
     */

    /**
     * Constructor de la clase.
     *
     * @param newsCommentRepository Repositorio de Game.
     */
    public NewsCommentService(NewsCommentRepository newsCommentRepository, NewsRepository newsRepository, UserRepository userRepository) {
        this.newsCommentRepository = newsCommentRepository;
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
    }


    @Override
    public NewsComment findById(Long id) {
        LOG.info("Finding game by id: {}", id);
        NewsComment newsComment = newsCommentRepository.findById(id).orElse(null);
        if (newsComment == null) {
            LOG.info("Game not found");
        }
        return newsComment;
    }

    @Override
    public NewsComment save(NewsComment newsComment, Long newsId, Long userId) {
        News news = newsRepository.findById(newsId).orElseThrow(() -> new IllegalArgumentException("News not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        newsComment.setNews(news);
        newsComment.setUser(user);

        return newsCommentRepository.save(newsComment);
    }


    @Override
    public void delete(Long id) {
        LOG.info("Deleting game by id: {}", id);
        newsCommentRepository.deleteById(id);
    }
}
