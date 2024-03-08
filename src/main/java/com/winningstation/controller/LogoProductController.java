package com.winningstation.controller;

import com.winningstation.entity.LogoProduct;
import com.winningstation.services.LogoProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de logo de producto.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "Logo Product Controller", description = "Operaciones para los logos de los productos")
@RestController
@RequestMapping("/logo-product")
public class LogoProductController {

  /** Servicio de logo de producto. */
  private final LogoProductService logoProductService;

  /**
   * Constructor de la clase.
   *
   * @param logoProductService Servicio de logo de producto.
   */
  public LogoProductController(LogoProductService logoProductService) {
    this.logoProductService = logoProductService;
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo logo de producto",
      description =
          "Guarda un nuevo logo de producto basado en la petición proporcionada y devuelve el logo de producto guardado")
  public LogoProduct save(@RequestBody LogoProduct logoProduct) {
    return logoProductService.save(logoProduct);
  }

  @GetMapping
  @Operation(
      summary = "Obtiene todos los logos de productos",
      description = "Devuelve una lista de todos los logos de productos")
  public List<LogoProduct> findAll() {
    return logoProductService.findAll();
  }

  @GetMapping("/{name}")
  @Operation(
      summary = "Busca logos de productos por su nombre",
      description =
          "Busca logos de productos basado en el nombre proporcionado y devuelve una lista de logos de productos encontrados")
  public List<LogoProduct> findByName(@PathVariable String name) {
    return logoProductService.findByName(name);
  }

  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un logo de producto",
      description =
          "Actualiza un logo de producto basado en el identificador y la petición proporcionados y devuelve el logo actualizado")
  public String update(@PathVariable Long id, @RequestBody String logo) {
    return logoProductService.update(id, logo);
  }

  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un logo de producto",
      description = "Elimina un logo de producto basado en el identificador proporcionado")
  public void deleteById(@PathVariable Long id) {
    logoProductService.deleteById(id);
  }
}
