package com.winninginnovations.controller;

import com.winninginnovations.entity.News;
import com.winninginnovations.entity.NewsComment;
import com.winninginnovations.entity.User;
import com.winninginnovations.services.interfaces.INewsCommentService;
import com.winninginnovations.services.interfaces.INewsService;
import com.winninginnovations.services.interfaces.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
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


    @PostMapping("/{newsId}/{userId}")
    public NewsComment createComment(@PathVariable Long newsId, @PathVariable Long userId, @RequestBody NewsComment newsComment) {
        return newsCommentService.save(newsComment, newsId, userId);
    }
}

