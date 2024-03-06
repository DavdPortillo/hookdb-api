package com.winningstation.controller;

import com.winningstation.entity.EditionProduct;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.IEditionProductService;
import com.winningstation.services.interfaces.IPlatformProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for platform product
 *
 * @author David Portillo Hoyos
 */
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
  public PlatformProduct save(@RequestBody PlatformProduct platformProduct) {
    return platformProductService.save(platformProduct);
  }

  /** Obtener todos los registros */
  @GetMapping
  public List<PlatformProduct> findAll() {
    return platformProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  public List<PlatformProduct> findByName(@PathVariable String name) {
    return platformProductService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  public PlatformProduct update(@PathVariable Long id, @RequestBody PlatformProduct request) {
    return platformProductService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    platformProductService.deleteById(id);
  }
}
