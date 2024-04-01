package com.winningstation.controller;

import com.winningstation.entity.EditionProduct;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.IEditionProductService;
import com.winningstation.services.interfaces.IPlatformProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
  public PlatformProduct save(
      @ModelAttribute PlatformProduct platformProduct, @RequestPart("file") MultipartFile file) {
    return platformProductService.save(platformProduct, file);
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
  @GetMapping("name/{name}")
  @Operation(
      summary = "Busca productos de plataformas por su nombre",
      description =
          "Busca productos de plataformas basado en el nombre proporcionado y devuelve una lista de productos de plataformas encontrados")
  public List<PlatformProduct> findByName(@PathVariable String name) {
    return platformProductService.findByName(name);
  }


    /** Obtener por su id */
    @GetMapping("/{id}")
    @Operation(
        summary = "Obtiene un producto de plataforma por su id",
        description = "Obtiene un producto de plataforma basado en el identificador proporcionado")
    public PlatformProduct findById(@PathVariable Long id) {
        return platformProductService.findById(id);
    }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un producto de plataforma",
      description =
          "Actualiza un producto de plataforma basado en el identificador y la petición proporcionados y devuelve el producto de plataforma actualizado")
  public PlatformProduct update(
      @PathVariable Long id,
      @ModelAttribute PlatformProduct request,
      @RequestPart(value = "file", required = false) MultipartFile file) {
    return platformProductService.update(id, request, file);
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
