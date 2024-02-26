package com.winningstation.controller;

import com.winningstation.entity.NewsAuthor;
import com.winningstation.services.interfaces.INewsAuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador para news authors.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/news-author")
public class NewsAuthorController {

    /**
     * Logger para la clase
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsAuthorController.class);

    /**
     * Servicio para los autores de noticias.
     */
    private final INewsAuthorService newsAuthorService;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param newsAuthorService El servicio para los autores de noticias.
     */
    public NewsAuthorController(INewsAuthorService newsAuthorService) {
        this.newsAuthorService = newsAuthorService;
    }

    /**
     * Crear un autor.
     *
     * @param newsAuthor Autor a crear.
     */
    @PostMapping
    public void save(NewsAuthor newsAuthor) {
        LOGGER.info("Saving news author: {}", newsAuthor);
        newsAuthorService.save(newsAuthor);
    }
}
