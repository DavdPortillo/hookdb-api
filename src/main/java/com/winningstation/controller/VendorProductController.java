package com.winningstation.controller;

import com.winningstation.entity.VendorProduct;
import com.winningstation.services.interfaces.IVendorProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for vendor product
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/vendor-product")
public class VendorProductController {

  /** Service for edition product */
  private final IVendorProductService vendorProductService;

  /**
   * Constructor
   *
   * @param vendorProductService Service for vendor product
   */
  public VendorProductController(IVendorProductService vendorProductService) {
    this.vendorProductService = vendorProductService;
  }

  /** Guardar un producto */
  @PostMapping
  public VendorProduct save(@RequestBody VendorProduct vendorProduct) {
    return vendorProductService.save(vendorProduct);
  }

  /** Obtener todos los registros */
  @GetMapping
  public List<VendorProduct> findAll() {
    return vendorProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  public List<VendorProduct> findByName(@PathVariable String name) {
    return vendorProductService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return vendorProductService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    vendorProductService.deleteById(id);
  }
}
