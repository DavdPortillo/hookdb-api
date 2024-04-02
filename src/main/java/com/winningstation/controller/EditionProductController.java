package com.winningstation.controller;

import com.winningstation.entity.EditionProduct;
import com.winningstation.services.interfaces.IEditionProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for edition product
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Edition Product Controller", description = "Operaciones para ediciones de productos")
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
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda una nueva edición de producto",
      description =
          "Guarda una nueva edición de producto basada en la petición proporcionada y devuelve la edición de producto guardada")
  public EditionProduct save(@RequestBody EditionProduct editionProduct) {
    return editionProductService.save(editionProduct);
  }

  /** Obtener todas las ediciones de productos */
  @GetMapping
  @Operation(
      summary = "Obtiene todas las ediciones de productos",
      description = "Devuelve una lista de todas las ediciones de productos")
  public List<EditionProduct> findAll() {
    return editionProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("name/{name}")
  @Operation(
      summary = "Busca ediciones de productos por su nombre",
      description =
          "Busca ediciones de productos basado en el nombre proporcionado y devuelve una lista de ediciones de productos encontrados")
  public List<EditionProduct> findByName(@PathVariable String name) {
    return editionProductService.findByName(name);
  }

  /** Obtener por su identificador */
  @GetMapping("/{id}")
  @Operation(
      summary = "Busca ediciones de productos por su identificador",
      description =
          "Busca ediciones de productos basado en el identificador proporcionado y devuelve una lista de ediciones de productos encontrados")
  public EditionProduct findById(@PathVariable Long id) {
    return editionProductService.findById(id);
  }

  /** Actualizar una edición de producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza una edición de producto",
      description =
          "Actualiza una edición de producto basada en el identificador y el nombre proporcionados y devuelve el nombre actualizado")
  public String update(@PathVariable Long id, @RequestBody String name) {
    return editionProductService.update(id, name);
  }

  /** Eliminar una edición de producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina una edición de producto",
      description = "Elimina una edición de producto basada en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    editionProductService.deleteById(id);
  }
}
