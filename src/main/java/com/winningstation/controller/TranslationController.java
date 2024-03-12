package com.winningstation.controller;

import com.winningstation.entity.Translation;
import com.winningstation.services.interfaces.ITranslationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para las traducciones
 *
 * @autjor David Portillo Hoyos
 */
@Tag(name = "Translation Controller", description = "Operaciones para las traducciones")
@RestController
@RequestMapping("translation")
public class TranslationController {

  /** Service for translations */
  private final ITranslationService translationService;

  /**
   * Constructor
   *
   * @param translationService Service for translations
   */
  public TranslationController(ITranslationService translationService) {
    this.translationService = translationService;
  }

  /** Guardar un producto */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda una nueva traducción",
      description =
          "Guarda una nueva traducción basada en la petición proporcionada y devuelve la traducción guardada")
  public Translation save(@RequestBody Translation translation) {
    return translationService.save(translation);
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todas las traducciones",
      description = "Devuelve una lista de todas las traducciones")
  public List<Translation> findAll() {
    return translationService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  @Operation(
      summary = "Busca traducciones por su nombre",
      description = "Busca traducciones basadas en el nombre proporcionado")
  public List<Translation> findByName(@PathVariable String name) {
    return translationService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza una traducción",
      description =
          "Actualiza una traducción basada en el identificador proporcionado y la petición proporcionada")
  public String update(@PathVariable Long id, @RequestBody String translation) {
    return translationService.update(id, translation);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina una traducción",
      description = "Elimina una traducción basada en el identificador proporcionado")
  public void delete(@PathVariable Long id) {
    translationService.deleteById(id);
  }
}
