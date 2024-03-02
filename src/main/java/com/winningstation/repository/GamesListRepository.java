package com.winningstation.repository;

import com.winningstation.entity.GamesList;
import com.winningstation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

  @Modifying
  @Query(value = "DELETE FROM gameslist_game WHERE game_id = :gameId", nativeQuery = true)
  void deleteAssociationsByGameId(@Param("gameId") Long gameId);
}
