package com.winningstation.controller;

import com.winningstation.entity.VendorProduct;
import com.winningstation.services.VendorProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Controlador de logo de producto.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Logo Product Controller", description = "Operaciones para los logos de los productos")
@RestController
@RequestMapping("/vendor-product")
public class VendorProductController {

  /** Servicio de logo de producto. */
  private final VendorProductService vendorProductService;

  /**
   * Constructor de la clase.
   *
   * @param vendorProductService Servicio de logo de producto.
   */
  public VendorProductController(VendorProductService vendorProductService) {
    this.vendorProductService = vendorProductService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo logo de producto",
      description =
          "Guarda un nuevo logo de producto basado en la petición proporcionada y devuelve el logo de producto guardado")
  public VendorProduct save(
          @ModelAttribute VendorProduct vendorProduct, @RequestPart("file") MultipartFile file) {
    return vendorProductService.save(vendorProduct, file);
  }

  @GetMapping
  @Operation(
      summary = "Obtiene todos los logos de productos",
      description = "Devuelve una lista de todos los logos de productos")
  public List<VendorProduct> findAll() {
    return vendorProductService.findAll();
  }

  @GetMapping("name/{name}")
  @Operation(
      summary = "Busca logos de productos por su nombre",
      description =
          "Busca logos de productos basado en el nombre proporcionado y devuelve una lista de logos de productos encontrados")
  public List<VendorProduct> findByName(@PathVariable String name) {
    return vendorProductService.findByName(name);
  }

    @GetMapping("/{id}")
    @Operation(
        summary = "Obtiene un logo de producto por su id",
        description = "Obtiene un logo de producto basado en el identificador proporcionado")
    public VendorProduct findById(@PathVariable Long id) {
        return vendorProductService.findById(id);

    }

  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un logo de producto",
      description =
          "Actualiza un logo de producto basado en el identificador y la petición proporcionados y devuelve el logo actualizado")
  public VendorProduct update(
      @PathVariable Long id,
      @ModelAttribute VendorProduct logo,
      @RequestPart(value = "file", required = false) MultipartFile file) {
    return vendorProductService.update(id, logo, file);
  }

  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un logo de producto",
      description = "Elimina un logo de producto basado en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    vendorProductService.deleteById(id);
  }
}
