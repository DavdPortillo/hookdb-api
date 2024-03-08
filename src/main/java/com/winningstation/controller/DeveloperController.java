package com.winningstation.controller;

import com.winningstation.entity.Developer;
import com.winningstation.services.interfaces.IDeveloperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que controla las peticiones relacionadas con los desarrolladores de los juegos.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/developer")
@Tag(name = "Developer Controller", description = "Operaciones para desarrolladores")
public class DeveloperController {

  /** Servicio para las plataformas. */
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
  @Operation(
      summary = "Guarda un nuevo desarrollador",
      description =
          "Guarda un nuevo desarrollador basado en la petición proporcionada y devuelve el desarrollador creado")
  @PostMapping
  public Developer saveDeveloper(@RequestBody Developer developer) {
    developerService.save(developer);
    return developer;
  }

  /**
   * Elimina un desarrollador.
   *
   * @param id Identificador del desarrollador a eliminar.
   */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un desarrollador",
      description = "Elimina un desarrollador basado en el identificador proporcionado")
  public void deleteDeveloper(@PathVariable Long id) {
    developerService.delete(id);
  }

  /**
   * Busca un desarrollador por su nombre.
   *
   * @param name Nombre del desarrollador a buscar.
   * @return El desarrollador encontrado.
   */
  @GetMapping("/name/{name}")
  @Operation(
      summary = "Busca un desarrollador por su nombre",
      description =
          "Busca un desarrollador basado en el nombre proporcionado y devuelve el desarrollador encontrado")
  public List<Developer> findDeveloperByName(@PathVariable String name) {
    return developerService.findByNameContaining(name);
  }

  /**
   * Edita un desarrollador.
   *
   * @param id Identificador del desarrollador a editar.
   * @param developerRequest Desarrollador a editar.
   * @return El desarrollador editado.
   */
  @PutMapping("/{id}")
  @Operation(
      summary = "Edita un desarrollador",
      description =
          "Edita un desarrollador basado en el identificador y la petición proporcionados y devuelve el desarrollador editado")
  public Developer editDeveloper(@PathVariable Long id, @RequestBody Developer developerRequest) {
    return developerService.edit(id, developerRequest);
  }
}
