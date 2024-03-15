package com.winningstation.services.interfaces;

import com.winningstation.entity.DLC;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Interfaz que define los métodos que se pueden realizar sobre un dlc.
 *
 * @author David Portillo Hoyos
 */
public interface IDLCService {

  /**
   * Método que guarda un dlc en la base de datos.
   *
   * @param dlc Dlc a guardar.
   * @param gameId Id del juego al que pertenece el dlc.
   * @param file Archivo del dlc.
   * @return Dlc guardado.
   */
  DLC save(DLC dlc, Long gameId, MultipartFile file);

  /**
   * Método que elimina un dlc de la base de datos.
   *
   * @param dlcId Id del dlc a eliminar.
   */
  void delete(Long dlcId);

  /**
   * Método que obtiene un dlc de la base de datos.
   *
   * @param dlcId Id del dlc a obtener.
   * @return Dlc obtenido.
   */
  DLC getById(Long dlcId);

  /**
   * Método que actualiza un dlc en la base de datos.
   *
   * @param id Id del dlc a actualizar.
   * @param dlcRequest Dlc con los datos actualizados.
   * @param file Archivo del dlc.
   * @return Dlc actualizado.
   */
  DLC update(Long id, DLC dlcRequest, MultipartFile file);

  /**
   * Método que obtiene todos los dlcs de un juego.
   *
   * @param gameId Id del juego.
   * @return Lista de dlcs del juego.
   */
  List<DLC> getByGameId(Long gameId);

  /**
   * Encuentra dlcs por su nombre.
   *
   * @param name Nombre del dlc a buscar.
   * @return Lista de dlcs encontrados.
   */
  List<DLC> findByNameContaining(String name);
}
