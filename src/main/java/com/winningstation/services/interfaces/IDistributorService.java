package com.winningstation.services.interfaces;

import com.winningstation.entity.Distributor;

import java.util.List;

/**
 * Interfaz que define los métodos que se pueden realizar sobre un distribuidor.
 *
 * @author David Portillo Hoyos
 */
public interface IDistributorService {

  /**
   * Método que guarda un distribuidor en la base de datos.
   *
   * @param distributor Distribuidor a guardar.
   * @return Distribuidor guardado.
   */
  Distributor save(Distributor distributor);

  /**
   * Método que busca por su nombre un distribuidor en la base de datos.
   *
   * @param name Nombre del distribuidor a buscar.
   * @return Distribuidor encontrado.
   */
  List<Distributor> findByName(String name);

  /**
   * Método que busca por su id un distribuidor en la base de datos.
   *
   * @param id Id del distribuidor a buscar.
   * @return Distribuidor encontrado.
   */
  Distributor findById(Long id);

  /**
   * Método que elimina un distribuidor de la base de datos.
   *
   * @param id Id del distribuidor a eliminar.
   */
  void delete(Long id);

  /**
   * Edita el nombre de un distribuidor.
   *
   * @param id Id del distribuidor a editar.
   * @param name Nuevo nombre del distribuidor.
   * @return Nombre del distribuidor editado.
   */
  String editName(Long id, String name);

  /**
   * Método que busca todos los distribuidores en la base de datos.
   *
   * @return Lista de distribuidores encontrados.
   */
  List<Distributor> findAll();
}
