package com.winningstation.controller;

import com.winningstation.entity.LogoProduct;
import com.winningstation.services.LogoProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador de logo de producto.
 *
 * @author David Portillo Hoyos
 */
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
  public LogoProduct save(@RequestBody LogoProduct logoProduct) {
    return logoProductService.save(logoProduct);
  }

  @GetMapping
  public List<LogoProduct> findAll() {
    return logoProductService.findAll();
  }

  @GetMapping("/{name}")
  public List<LogoProduct> findByName(@PathVariable String name) {
    return logoProductService.findByName(name);
  }

  @PutMapping("/{id}")
  public String update(@PathVariable Long id, @RequestBody String logo) {
    return logoProductService.update(id, logo);
  }

  @DeleteMapping("/{id}")
  public void deleteById(@PathVariable Long id) {
    logoProductService.deleteById(id);
  }
}
