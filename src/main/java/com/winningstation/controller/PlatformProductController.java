package com.winningstation.controller;

import com.winningstation.entity.EditionProduct;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.IEditionProductService;
import com.winningstation.services.interfaces.IPlatformProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for platform product
 *
 * @author David Portillo Hoyos
 */
@Tag(
    name = "Platform Product Controller",
    description = "Operaciones para los productos de las plataformas")
@RestController
@RequestMapping("/platform-product")
public class PlatformProductController {
  /** Service for edition product */
  private final IPlatformProductService platformProductService;

  /**
   * Constructor
   *
   * @param platformProductService Service for platform product
   */
  public PlatformProductController(IPlatformProductService platformProductService) {
    this.platformProductService = platformProductService;
  }

  /** Guardar un producto */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo producto de plataforma",
      description =
          "Guarda un nuevo producto de plataforma basado en la petición proporcionada y devuelve el producto de plataforma guardado")
  public PlatformProduct save(@RequestBody PlatformProduct platformProduct) {
    return platformProductService.save(platformProduct);
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todos los productos de plataformas",
      description = "Devuelve una lista de todos los productos de plataformas")
  public List<PlatformProduct> findAll() {
    return platformProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  @Operation(
      summary = "Busca productos de plataformas por su nombre",
      description =
          "Busca productos de plataformas basado en el nombre proporcionado y devuelve una lista de productos de plataformas encontrados")
  public List<PlatformProduct> findByName(@PathVariable String name) {
    return platformProductService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un producto de plataforma",
      description =
          "Actualiza un producto de plataforma basado en el identificador y la petición proporcionados y devuelve el producto de plataforma actualizado")
  public PlatformProduct update(@PathVariable Long id, @RequestBody PlatformProduct request) {
    return platformProductService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un producto de plataforma",
      description = "Elimina un producto de plataforma basado en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    platformProductService.deleteById(id);
  }
}
