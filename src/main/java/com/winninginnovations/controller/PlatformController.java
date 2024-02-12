package com.winninginnovations.controller;

import com.winninginnovations.entity.Platform;
import com.winninginnovations.services.interfaces.IPlatformService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de la entidad Platform.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/platform")
public class PlatformController {

    /**
     * Logger para la clase.
     */
    private static final Logger LOG = LoggerFactory.getLogger(PlatformController.class);

    /**
     * Servicio para las plataformas.
     */
    private final IPlatformService platformService;

    /**
     * Constructor para la inyección de dependencias.
     *
     * @param platformService Servicio para las plataformas.
     */
    public PlatformController(IPlatformService platformService) {
        this.platformService = platformService;
    }

    /**
     * Guarda una nueva plataforma.
     *
     * @param platform La plataforma a guardar.
     */
    @PostMapping
    public Platform savePlatform(@RequestBody Platform platform) {
        platformService.save(platform);
        return platform;
    }
}
