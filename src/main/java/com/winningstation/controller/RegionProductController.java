package com.winningstation.controller;

import com.winningstation.entity.RegionProduct;
import com.winningstation.entity.VendorProduct;
import com.winningstation.services.interfaces.IRegionProductService;
import com.winningstation.services.interfaces.IVendorProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for region product
 *
 * @author David Portillo Hoyos
 */
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
  public RegionProduct save(@RequestBody RegionProduct regionProduct) {
    return regionProductService.save(regionProduct);
  }

  /** Obtener todos los registros */
  @GetMapping
  public List<RegionProduct> findAll() {
    return regionProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  public List<RegionProduct> findByName(@PathVariable String name) {
    return regionProductService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return regionProductService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    regionProductService.deleteById(id);
  }
}
