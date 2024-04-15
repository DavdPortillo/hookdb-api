package com.winningstation.controller;

import com.winningstation.entity.Feature;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.IFeatureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Clase que controla las peticiones relacionadas con las características de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Feature Controller", description = "Operaciones para características de los juegos")
@RestController
@RequestMapping("/feature")
public class FeatureController {

  /** Servicio para las características de los juegos. */
  private final IFeatureService featureService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param featureService Servicio para las características de los juegos.
   */
  public FeatureController(IFeatureService featureService) {
    this.featureService = featureService;
  }

  /**
   * Método que obtiene todas las características de los juegos.
   *
   * @return Características obtenidas.
   */
  @GetMapping
  @Operation(
      summary = "Obtiene todas las características de los juegos",
      description = "Devuelve una lista de todas las características de los juegos")
  public List<Feature> findAll() {
    return featureService.findAll();
  }

  /**
   * Método que obtiene las características de un juego por su nombre.
   *
   * @param name Nombre de las características a obtener.
   * @return Características obtenidas.
   */
  @GetMapping("name/{name}")
  @Operation(
      summary = "Busca características de juegos por su nombre",
      description =
          "Busca características de juegos basado en el nombre proporcionado y devuelve una lista de características de juegos encontrados")
  public List<Feature> findByName(@PathVariable String name) {
    return featureService.findByName(name);
  }

  /**
   * Edita por el nombre
   *
   * @param id Id
   */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza una característica de juego",
      description =
          "Actualiza una característica de juego basada en el identificador y el nombre proporcionados y devuelve el nombre actualizado")
  public Feature update(
      @PathVariable Long id,
      @ModelAttribute Feature request,
      @RequestPart(value = "file", required = false) MultipartFile file) {
    return featureService.update(id, request, file);
  }

  /**
   * Método que elimina las características de un juego por su id.
   *
   * @param id Id de las características a eliminar.
   */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina una característica de juego",
      description = "Elimina una característica de juego basada en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    featureService.deleteById(id);
  }

  /**
   * Guarda un feature.
   *
   * @param feature Feature de juego a guardar
   * @return Feature guardado
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda una nueva característica de juego",
      description =
          "Guarda una nueva característica de juego basada en la petición proporcionada y devuelve la característica de juego guardada")
  public Feature save(@ModelAttribute Feature feature, @RequestPart("file") MultipartFile file) {
    return featureService.save(feature, file);
  }

  /**
   * Método que obtiene las características de un juego por su id.
   *
   * @param id Id de las características a obtener.
   * @return Características obtenidas.
   */
  @GetMapping("/{id}")
  @Operation(
      summary = "Busca características de juegos por su id",
      description =
          "Busca características de juegos basado en el id proporcionado y devuelve una lista de características de juegos encontrados")
  public Feature findById(@PathVariable Long id) {
    return featureService.findById(id);
  }
}
