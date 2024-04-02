package com.winningstation.controller;

import com.winningstation.entity.NumberPlayer;
import com.winningstation.entity.PlatformProduct;
import com.winningstation.services.interfaces.INumberPlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Tag(
    name = "Number Player Controller",
    description = "Operaciones para el número de jugadores de un juego")
@Controller
@RestController("/number-player")
public class NumberPlayerController {

  /** Servicio de número de jugadores. */
  private final INumberPlayerService numberPlayerService;

  /**
   * Constructor de la clase.
   *
   * @param numberPlayerService Servicio de número de jugadores.
   */
  public NumberPlayerController(INumberPlayerService numberPlayerService) {
    this.numberPlayerService = numberPlayerService;
  }

  /** Guardar un numero de jugador */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo número de jugadores",
      description =
          "Guarda un nuevo número de jugadores basado en la petición proporcionada y devuelve el número de jugadores guardado")
  public NumberPlayer save(@RequestBody NumberPlayer numberPlayer) {
    return numberPlayerService.save(numberPlayer);
  }

  /** Obtener todos los registros */
  @GetMapping
  @Operation(
      summary = "Obtiene todos los números de jugadores",
      description = "Devuelve una lista de todos los números de jugadores")
  public List<NumberPlayer> findAll() {
    return numberPlayerService.findAll();
  }

  /** Obtener por su nombre */
  @GetMapping("number-player/{numberPlayers}")
  @Operation(
      summary = "Obtiene un número de jugadores por su número",
      description = "Obtiene un número de jugadores basado en el número proporcionado")
  public NumberPlayer findByNumberPlayers(@PathVariable Integer numberPlayers) {
    return numberPlayerService.getByNumberPlayers(numberPlayers);
  }

  /** Obtener por su id */
  @GetMapping("/{id}")
  @Operation(
      summary = "Obtiene un número de jugadores por su identificador",
      description = "Obtiene un número de jugadores basado en el identificador proporcionado")
  public NumberPlayer findById(@PathVariable Long id) {
    return numberPlayerService.getById(id);
  }

  /** Actualizar un producto */
  @PutMapping("/{id}")
  @Operation(
      summary = "Actualiza un número de jugadores",
      description =
          "Actualiza un número de jugadores basado en el identificador proporcionado y la petición proporcionada")
  public Integer update(@PathVariable Long id, @RequestBody Integer numberPlayerRequest) {
    return numberPlayerService.update(id, numberPlayerRequest);
  }

  /** Eliminar un producto */
  @DeleteMapping("/{id}")
  @Operation(
      summary = "Elimina un número de jugadores",
      description = "Elimina un número de jugadores basado en el identificador proporcionado")
  public void delete(@PathVariable Long id) {
    NumberPlayer numberPlayer = numberPlayerService.getById(id);
    numberPlayerService.delete(numberPlayer);
  }
}
