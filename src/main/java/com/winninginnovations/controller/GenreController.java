package com.winninginnovations.controller;

import com.winninginnovations.entity.Genre;
import com.winninginnovations.entity.Platform;
import com.winninginnovations.services.interfaces.IGenreService;
import com.winninginnovations.services.interfaces.IPlatformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que controla las peticiones relacionadas con los géneros de los juegos.
 */
@RestController
@RequestMapping("/genre")
public class GenreController {

    /**
     * Logger para la clase.
     */
    private static final Logger LOG = LoggerFactory.getLogger(GenreController.class);

    /**
     * Servicio para las plataformas.
     */
    private final IGenreService genreService;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param genreService Servicio para las plataformas.
     */
    public GenreController(IGenreService genreService) {
        this.genreService = genreService;
    }

    /**
     * Guarda un nuevo género.
     *
     * @param genre El género a guardar.
     */
    @PostMapping
    public Genre saveGenre(@RequestBody Genre genre) {
        genreService.save(genre);
        return genre;
    }
}


