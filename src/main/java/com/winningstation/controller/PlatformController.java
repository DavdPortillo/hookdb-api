package com.winningstation.controller;

import com.winningstation.entity.Platform;
import com.winningstation.services.interfaces.IPlatformService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  /** Obtener todos los registros */
  @GetMapping
  public List<Platform> findAll() {
    return platformService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  public List<Platform> findByName(@PathVariable String name) {
    return platformService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return platformService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    platformService.deleteById(id);
  }
}
