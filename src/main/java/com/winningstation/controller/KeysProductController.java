package com.winningstation.controller;

import com.winningstation.entity.KeysProduct;
import com.winningstation.entity.RegionProduct;
import com.winningstation.services.interfaces.IKeysProductService;
import com.winningstation.services.interfaces.IRegionProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for keys product
 *
 * @author David Portillo Hoyos
 */
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
  public KeysProduct save(@RequestBody KeysProduct keysProduct) {
    return keysProductService.save(keysProduct);
  }

  /** Obtener todos los registros */
  @GetMapping
  public List<KeysProduct> findAll() {
    return keysProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  public List<KeysProduct> findByName(@PathVariable String name) {
    return keysProductService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return keysProductService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    keysProductService.deleteById(id);
  }
}
