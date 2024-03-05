package com.winningstation.controller;

import com.winningstation.entity.Distributor;
import com.winningstation.services.interfaces.IDistributorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que controla las peticiones relacionadas con los distribuidores de los juegos.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/distributor")
public class DistributorController {

  /** Servicio para los distribuidores. */
  private final IDistributorService distributorService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param distributorService Servicio para los distribuidores.
   */
  public DistributorController(IDistributorService distributorService) {
    this.distributorService = distributorService;
  }

  /**
   * Guarda un nuevo distribuidor.
   *
   * @param distributor El distribuidor a guardar.
   * @return El distribuidor guardado.
   */
  @PostMapping
  public Distributor saveDistributor(@RequestBody Distributor distributor) {
    distributorService.save(distributor);
    return distributor;
  }

  /**
   * Busca un distribuidor por su nombre.
   *
   * @param name Nombre del distribuidor a buscar.
   * @return Distribuidor encontrado.
   */
  @GetMapping("/search/{name}")
  public List<Distributor> findDistributorByName(@PathVariable String name) {
    return distributorService.findByName(name);
  }

  @DeleteMapping("/{id}")
  public void deleteDistributor(@PathVariable Long id) {
    distributorService.delete(id);
  }

  @PutMapping("/{id}/name")
  public String editDistributorName(@PathVariable Long id, @RequestBody String name) {
    return distributorService.editName(id, name);
  }

  @GetMapping
  public List<Distributor> findAllDistributors() {
    return distributorService.findAll();
  }
}
