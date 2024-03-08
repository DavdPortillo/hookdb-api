package com.winningstation.controller;

import com.winningstation.entity.VendorProduct;
import com.winningstation.services.interfaces.IVendorProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for vendor product
 *
 * @author David Portillo Hoyos
 */
@Tag(
    name = "Vendor Product Controller",
    description = "Operaciones para los productos de los vendedores")
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
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo producto de vendedor",
      description =
          "Guarda un nuevo producto de vendedor basado en la petición proporcionada y devuelve el producto de vendedor guardado")
  public VendorProduct save(@RequestBody VendorProduct vendorProduct) {
    return vendorProductService.save(vendorProduct);
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todos los productos de vendedores",
      description = "Devuelve una lista de todos los productos de vendedores")
  public List<VendorProduct> findAll() {
    return vendorProductService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("/{name}")
  @Operation(
      summary = "Busca productos de vendedores por su nombre",
      description =
          "Busca productos de vendedores basado en el nombre proporcionado y devuelve una lista de productos de vendedores encontrados")
  public List<VendorProduct> findByName(@PathVariable String name) {
    return vendorProductService.findByName(name);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un producto de vendedor",
      description =
          "Actualiza un producto de vendedor basado en el identificador y la petición proporcionados y devuelve el producto de vendedor actualizado")
  public String update(@PathVariable Long id, @RequestBody String request) {
    return vendorProductService.update(id, request);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un producto de vendedor",
      description = "Elimina un producto de vendedor basado en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    vendorProductService.deleteById(id);
  }
}
