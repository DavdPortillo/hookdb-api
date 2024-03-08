package com.winningstation.controller;

import com.winningstation.entity.KeysProduct;
import com.winningstation.entity.RegionProduct;
import com.winningstation.services.interfaces.IKeysProductService;
import com.winningstation.services.interfaces.IRegionProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for keys product
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Keys Product Controller", description = "Operaciones para los productos de claves")
@RestController
@RequestMapping("/keys-product")
public class KeysProductController {
  /** Service for edition product */
  private final IKeysProductService keysProductService;

  /**
   * Constructor
   *
   * @param keysProductService Service for keys product
   */
  public KeysProductController(IKeysProductService keysProductService) {
    this.keysProductService = keysProductService;
  }

  /** Guardar un producto */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo producto de claves",
      description =
          "Guarda un nuevo producto de claves basado en la petición proporcionada y devuelve el producto de claves guardado")
  public KeysProduct save(@RequestBody KeysProduct keysProduct) {
    return keysProductService.save(keysProduct);
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todos los productos de claves",
      description = "Devuelve una lista de todos los productos de claves")
  public List<KeysProduct> findAll() {
    return keysProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  @Operation(
      summary = "Busca productos de claves por su nombre",
      description =
          "Busca productos de claves basado en el nombre proporcionado y devuelve una lista de productos de claves encontrados")
  public List<KeysProduct> findByName(@PathVariable String name) {
    return keysProductService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un producto de claves",
      description =
          "Actualiza un producto de claves basado en el identificador y la petición proporcionados y devuelve el nombre actualizado")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return keysProductService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un producto de claves",
      description = "Elimina un producto de claves basado en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    keysProductService.deleteById(id);
  }
}
