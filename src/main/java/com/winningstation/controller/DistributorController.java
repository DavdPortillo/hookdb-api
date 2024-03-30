package com.winningstation.controller;

import com.winningstation.entity.Distributor;
import com.winningstation.services.interfaces.IDistributorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Clase que controla las peticiones relacionadas con los distribuidores de los juegos.
 *
 * @author David Portillo Hoyos
 */
@RestController
@RequestMapping("/distributor")
@Tag(name = "Distributor Controller", description = "Operaciones para distribuidores")
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
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo distribuidor",
      description =
          "Guarda un nuevo distribuidor basado en la petición proporcionada y devuelve el distribuidor guardado")
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
  @GetMapping("/name/{name}")
  @Operation(
      summary = "Busca un distribuidor por su nombre",
      description =
          "Busca un distribuidor basado en el nombre proporcionado y devuelve el distribuidor encontrado")
  public List<Distributor> findDistributorByName(@PathVariable String name) {
    return distributorService.findByName(name);
  }

  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un distribuidor",
      description = "Elimina un distribuidor basado en el identificador proporcionado")
  public void deleteDistributor(@PathVariable Long id) {
    distributorService.delete(id);
  }

  @PutMapping("/{id}")
  @Operation(
      summary = "Edita el nombre de un distribuidor",
      description =
          "Edita el nombre de un distribuidor basado en el identificador y el nombre proporcionados y devuelve el nombre editado")
  public String editDistributorName(@PathVariable Long id, @RequestBody String name) {
    return distributorService.editName(id, name);
  }

  @GetMapping
  @Operation(
      summary = "Obtiene todos los distribuidores",
      description = "Devuelve una lista de todos los distribuidores")
  public List<Distributor> findAllDistributors() {
    return distributorService.findAll();
  }

  @GetMapping("/{id}")
  @Operation(
      summary = "Obtiene un distribuidor por su identificador",
      description = "Devuelve un distribuidor basado en el identificador proporcionado")
  public Distributor findDistributorById(@PathVariable Long id) {
    return distributorService.findById(id);
  }
}
