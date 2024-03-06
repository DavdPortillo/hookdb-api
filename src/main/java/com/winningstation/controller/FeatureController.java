package com.winningstation.controller;

import com.winningstation.entity.Feature;
import com.winningstation.services.interfaces.IFeatureService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que controla las peticiones relacionadas con las características de los juegos.
 *
 * @author David Portillo Hoyos
 */
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
  public List<Feature> findAll() {
    return featureService.findAll();
  }

  /**
   * Método que obtiene las características de un juego por su nombre.
   *
   * @param name Nombre de las características a obtener.
   * @return Características obtenidas.
   */
  @GetMapping("/{name}")
  public List<Feature> findByName(@PathVariable String name) {
    return featureService.findByName(name);
  }

  /**
   * Edita por el nombre
   *
   * @param name Nombre
   * @param id Id
   */
  @PutMapping("/{id}")
  public String editByName(@PathVariable Long id, @RequestBody String name) {
    return featureService.editByName(id, name);
  }

  /**
   * Método que elimina las características de un juego por su id.
   *
   * @param id Id de las características a eliminar.
   */
  @DeleteMapping("/{id}")
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
  public Feature save(@RequestBody Feature feature) {
    return featureService.save(feature);
  }
}
