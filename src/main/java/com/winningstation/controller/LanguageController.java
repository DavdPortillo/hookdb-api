package com.winningstation.controller;

import com.winningstation.entity.Language;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.ILanguageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de la entidad Language.
 *
 * @author David Portillo Hoyos
 */
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
  public Language saveLanguage(@RequestBody Language language) {
    languageService.save(language);
    return language;
  }

  /** Obtener todos los registros */
  @GetMapping
  public List<Language> findAll() {
    return languageService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  public List<Language> findByName(@PathVariable String name) {
    return languageService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return languageService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    languageService.deleteById(id);
  }
}
