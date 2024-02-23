package com.winninginnovations.repository;

import com.winninginnovations.entity.GamesList;
import com.winninginnovations.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la lista de juegos.
 *
 * @author David
 */
@Repository
public interface GamesListRepository extends JpaRepository<GamesList, Long> {

  /**
   * Busca una lista de juegos por su nombre y el usuario al que pertenece.
   *
   * @param name Nombre de la lista de juegos.
   * @param user Usuario al que pertenece la lista de juegos.
   * @return Lista de juegos.
   */
  GamesList findByNameAndUser(String name, User user);
}
