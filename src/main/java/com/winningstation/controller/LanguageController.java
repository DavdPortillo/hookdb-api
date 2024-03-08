package com.winningstation.controller;

import com.winningstation.entity.Language;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.ILanguageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de la entidad Language.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Language Controller", description = "Operaciones para los idiomas de los juegos")
@RestController
@RequestMapping("/language")
public class LanguageController {

  /** Servicio para los idiomas. */
  private final ILanguageService languageService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param languageService Servicio para los idiomas.
   */
  public LanguageController(ILanguageService languageService) {
    this.languageService = languageService;
  }

  /**
   * Guarda un nuevo idioma.
   *
   * @param language El idioma a guardar.
   * @return El idioma guardado.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo idioma",
      description =
          "Guarda un nuevo idioma basado en la petición proporcionada y devuelve el idioma guardado")
  public Language saveLanguage(@RequestBody Language language) {
    languageService.save(language);
    return language;
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todos los idiomas",
      description = "Devuelve una lista de todos los idiomas")
  public List<Language> findAll() {
    return languageService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  @Operation(
      summary = "Busca idiomas por su nombre",
      description =
          "Busca idiomas basado en el nombre proporcionado y devuelve una lista de idiomas encontrados")
  public List<Language> findByName(@PathVariable String name) {
    return languageService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un idioma",
      description =
          "Actualiza un idioma basado en el identificador y la petición proporcionados y devuelve el nombre actualizado")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return languageService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un idioma",
      description = "Elimina un idioma basado en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    languageService.deleteById(id);
  }
}
