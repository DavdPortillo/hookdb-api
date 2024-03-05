package com.winningstation.repository;

import com.winningstation.dto.ListDTO;
import com.winningstation.entity.GamesList;
import com.winningstation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

  /**
   * Encuentra las listas de juegos de un usuario.
   *
   * @param userId id del usuario.
   * @return Lista de juegos.
   */
  @Query(
      "SELECT new com.winningstation.dto.ListDTO(g.id, g.name, g.date, COUNT(game.id)) "
          + "FROM GamesList g "
          + "LEFT JOIN g.games game "
          + "WHERE g.user.id = :userId "
          + "GROUP BY g.id")
  List<ListDTO> findListByUserId(@Param("userId") Long userId);

  /**
   * Encuentra las listas de juegos de un usuario por un patrón de nombre.
   *
   * @param userId id del usuario.
   * @param namePattern patrón de nombre.
   * @return Lista de juegos.
   */
  @Query(
      "SELECT new com.winningstation.dto.ListDTO(g.id, g.name, g.date, COUNT(game.id)) "
          + "FROM GamesList g "
          + "LEFT JOIN g.games game "
          + "WHERE g.user.id = :userId AND LOWER(g.name) LIKE LOWER(CONCAT('%', :namePattern, '%')) "
          + "GROUP BY g.id")
  List<ListDTO> findListByUserIdAndNamePattern(
      @Param("userId") Long userId, @Param("namePattern") String namePattern);
}
