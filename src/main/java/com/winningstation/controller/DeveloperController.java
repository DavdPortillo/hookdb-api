package com.winningstation.controller;

import com.winningstation.entity.Developer;
import com.winningstation.services.interfaces.IDeveloperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que controla las peticiones relacionadas con los desarrolladores de los juegos.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/developer")
public class DeveloperController {


    /**
     * Logger para la clase.
     */
    private static final Logger LOG = LoggerFactory.getLogger(DeveloperController.class);

    /**
     * Servicio para las plataformas.
     */
    private final IDeveloperService developerService;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param developerService Servicio para las plataformas.
     */
    public DeveloperController(IDeveloperService developerService) {
        this.developerService = developerService;
    }

    /**
     * Guarda un nuevo desarrollador.
     *
     * @param developer El desarrollador a guardar.
     */
    @PostMapping
    public Developer saveDeveloper(@RequestBody Developer developer) {
        LOG.info("Saving developer: {}", developer);
        developerService.save(developer);
        return developer;
    }


}
