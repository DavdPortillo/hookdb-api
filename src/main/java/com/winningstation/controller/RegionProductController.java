package com.winningstation.controller;

import com.winningstation.entity.RegionProduct;
import com.winningstation.services.interfaces.IRegionProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for region product
 *
 * @author David Portillo Hoyos
 */
@Tag(
    name = "Region Product Controller",
    description = "Operaciones para los productos de las regiones")
@RestController
@RequestMapping("/region-product")
public class RegionProductController {

  /** Service for edition product */
  private final IRegionProductService regionProductService;

  /**
   * Constructor
   *
   * @param regionProductService Service for region product
   */
  public RegionProductController(IRegionProductService regionProductService) {
    this.regionProductService = regionProductService;
  }

  /** Guardar un producto */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo producto de región",
      description =
          "Guarda un nuevo producto de región basado en la petición proporcionada y devuelve el producto de región guardado")
  public RegionProduct save(@RequestBody RegionProduct regionProduct) {
    return regionProductService.save(regionProduct);
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todos los productos de regiones",
      description = "Devuelve una lista de todos los productos de regiones")
  public List<RegionProduct> findAll() {
    return regionProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("name/{name}")
  @Operation(
      summary = "Busca productos de regiones por su nombre",
      description =
          "Busca productos de regiones basado en el nombre proporcionado y devuelve una lista de productos de regiones encontrados")
  public List<RegionProduct> findByName(@PathVariable String name) {
    return regionProductService.findByName(name);
  }

  /** Obtener por su id */
  @GetMapping("/{id}")
  @Operation(
      summary = "Busca un producto de región por su identificador",
      description =
          "Busca un producto de región basado en el identificador proporcionado y devuelve el producto de región encontrado")
  public RegionProduct findById(@PathVariable Long id) {
    return regionProductService.findById(id);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un producto de región",
      description =
          "Actualiza un producto de región basado en el identificador y la petición proporcionados y devuelve el producto de región actualizado")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return regionProductService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un producto de región",
      description = "Elimina un producto de región basado en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    regionProductService.deleteById(id);
  }
}
