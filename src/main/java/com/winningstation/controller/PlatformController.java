package com.winningstation.controller;

import com.winningstation.entity.Platform;
import com.winningstation.services.interfaces.IPlatformService;
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

  /** Servicio para las plataformas. */
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
   * @return La plataforma guardada.
   */
  @PostMapping
  public Platform savePlatform(@RequestBody Platform platform) {
    platformService.save(platform);
    return platform;
  }
}
