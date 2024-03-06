package com.winningstation.controller;

import com.winningstation.entity.EditionProduct;
import com.winningstation.services.interfaces.IEditionProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for edition product
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/edition-product")
public class EditionProductController {

  /** Service for edition product */
  private final IEditionProductService editionProductService;

  /**
   * Constructor
   *
   * @param editionProductService Service for edition product
   */
  public EditionProductController(IEditionProductService editionProductService) {
    this.editionProductService = editionProductService;
  }

  /** Guardar una edición de producto */
  @PostMapping
  public EditionProduct save(@RequestBody EditionProduct editionProduct) {
    return editionProductService.save(editionProduct);
  }

  /** Obtener todas las ediciones de productos */
  @GetMapping
  public List<EditionProduct> findAll() {
    return editionProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  public List<EditionProduct> findByName(@PathVariable String name) {
    return editionProductService.findByName(name);
  }

  /** Actualizar una edición de producto */
  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody String name) {
    return editionProductService.update(id, name);
  }

  /** Eliminar una edición de producto */
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    editionProductService.deleteById(id);
  }
}
