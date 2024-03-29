package com.winningstation.controller;

import com.winningstation.entity.Platform;
import com.winningstation.services.interfaces.IPlatformService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de la entidad Platform.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Platform Controller", description = "Operaciones para las plataformas de los juegos")
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
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda una nueva plataforma",
      description =
          "Guarda una nueva plataforma basada en la petición proporcionada y devuelve la plataforma guardada")
  public Platform savePlatform(@RequestBody Platform platform) {
    platformService.save(platform);
    return platform;
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todas las plataformas",
      description = "Devuelve una lista de todas las plataformas")
  public List<Platform> findAll() {
    return platformService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  @Operation(
      summary = "Busca plataformas por su nombre",
      description =
          "Busca plataformas basado en el nombre proporcionado y devuelve una lista de plataformas encontradas")
  public List<Platform> findByName(@PathVariable String name) {
    return platformService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza una plataforma",
      description =
          "Actualiza una plataforma basada en el identificador y la petición proporcionados y devuelve la plataforma actualizada")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return platformService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina una plataforma",
      description = "Elimina una plataforma basada en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    platformService.deleteById(id);
  }


    @GetMapping("/{id}")
    @Operation(
        summary = "Obtiene una plataforma por su id",
        description =
            "Devuelve una plataforma basada en el identificador proporcionado")
    public Platform findById(@PathVariable Long id) {
        return platformService.findById(id);
    }
}
