package com.winninginnovations.controller;

import com.winninginnovations.entity.News;
import com.winninginnovations.services.interfaces.INewsCommentService;
import com.winninginnovations.services.interfaces.INewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para news.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/news")
public class NewsController {

    /**
     * Logger para la clase
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(News.class);

    /**
     * Servicio para los comentarios de noticias.
     */
    private final INewsService newsService;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param newsService El servicio para las noticias.
     */
    public NewsController(INewsService newsService) {
        this.newsService = newsService;
    }

    /**
     * Crear una noticia.
     *
     * @param news Noticia a crear.
     * @return La noticia creada.
     */
    @PostMapping
    public News save(News news) {
        LOGGER.info("Saving news: {}", news);
        return newsService.save(news);
    }

}
