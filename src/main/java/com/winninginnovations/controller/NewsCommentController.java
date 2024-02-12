package com.winninginnovations.controller;

import com.winninginnovations.entity.NewsComment;
import com.winninginnovations.services.interfaces.INewsCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Controlador para news comments.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/news-comment")
public class NewsCommentController {

    /**
     * Logger para la clase
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(NewsCommentController.class);

    /**
     * Servicio para los comentarios de noticias.
     */
    private final INewsCommentService newsCommentService;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param newsCommentService El servicio para los comentarios de noticias.
     */
    public NewsCommentController(INewsCommentService newsCommentService) {
        this.newsCommentService = newsCommentService;
    }

    /**
     * Crear un comentario.
     *
     * @param newsComment Comentario a crear.
     * @return El comentario creado.
     */
    @PostMapping
    public NewsComment save(NewsComment newsComment) {
        LOGGER.info("Saving news comment: {}", newsComment);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        newsComment.setDate(LocalDate.now().format(formatter));
        return newsCommentService.save(newsComment);
    }
}

