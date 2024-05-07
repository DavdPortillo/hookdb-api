package com.winningstation.controller;

import com.winningstation.entity.DLC;
import com.winningstation.services.interfaces.IDLCService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Clase que controla las peticiones relacionadas con los contenidos descargables de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Tag(name = "DLC Controller", description = "Operaciones para contenidos descargables")
@RestController
@RequestMapping("/dlc")
public class DLCController {

  /** Servicio para los contenidos descargables. */
  private final IDLCService dlcService;

  /**
   * Constructor para la inyección de dependencias.
   *
   * @param dlcService Servicio para los contenidos descargables.
   */
  public DLCController(IDLCService dlcService) {
    this.dlcService = dlcService;
  }

  /**
   * Guarda un nuevo contenido descargable.
   *
   * @param dlc El contenido descargable a guardar.
   * @return El contenido descargable guardado.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  @Operation(
      summary = "Guarda un nuevo contenido descargable",
      description =
          "Guarda un nuevo contenido descargable basado en la petición proporcionada y devuelve el contenido descargable guardado")
  public DLC save(@ModelAttribute DLC dlc, @RequestPart("file") MultipartFile file) {
    return dlcService.save(dlc, dlc.getGame().getId(), file);
  }

  /**
   * Elimina un contenido descargable.
   *
   * @param dlcId id del contenido descargable a eliminar.
   */
  @DeleteMapping("{dlcId}")
  @Operation(
      summary = "Elimina un contenido descargable",
      description = "Elimina un contenido descargable basado en el identificador proporcionado")
  public void delete(@PathVariable Long dlcId) {
    dlcService.delete(dlcId);
  }

  /**
   * Edita un contenido descargable.
   *
   * @param id id del contenido descargable a editar.
   * @param dlcRequest contenido descargable con los datos actualizados.
   * @return contenido descargable actualizado.
   */
  @PutMapping("{id}")
  @Operation(
      summary = "Edita un contenido descargable",
      description =
          "Edita un contenido descargable basado en el identificador y la petición proporcionados y devuelve el contenido descargable actualizado")
  public DLC update(
      @PathVariable Long id,
      @ModelAttribute DLC dlcRequest,
      @RequestPart(value = "file", required = false) MultipartFile file){
    return dlcService.update(id, dlcRequest, file);
  }

  /**
   * Obtiene todos los contenidos descargables de un juego.
   *
   * @param dlcId id del contenido descargable a obtener.
   * @return contenido descargable obtenido.
   */
  @GetMapping("game/{dlcId}")
  @Operation(
      summary = "Obtiene todos los contenidos descargables de un juego",
      description =
          "Devuelve todos los contenidos descargables de un juego basado en el identificador proporcionado")
  public List<DLC> getByGameId(@PathVariable Long dlcId) {
    return dlcService.getByGameId(dlcId);
  }

  /** Obtiene id un contenido descargable. */
  @Operation(
      summary = "Obtiene un contenido descargable por su identificador",
      description = "Devuelve un contenido descargable basado en el identificador proporcionado")
  @GetMapping("{dlcId}")
  public DLC getById(@PathVariable Long dlcId) {
    return dlcService.getById(dlcId);
  }

  /**
   * Obtiene todos los contenidos descargables.
   */
    @Operation(
        summary = "Obtiene todos los contenidos descargables",
        description = "Devuelve todos los contenidos descargables")
    @GetMapping
    public List<DLC> getAll() {
        return dlcService.getAll();
    }

  /**
   * Encuentra contenidos descargables por su nombre.
   *
   * @param name Nombre del contenido descargable a buscar.
   * @return Lista de contenidos descargables encontrados.
   */
  @GetMapping("name/{name}")
  @Operation(
      summary = "Encuentra contenidos descargables por su nombre",
      description =
          "Busca contenidos descargables basado en el nombre proporcionado y devuelve una lista de contenidos descargables encontrados")
  public List<DLC> findByNameContaining(@PathVariable String name) {
    return dlcService.findByNameContaining(name);
  }
}
