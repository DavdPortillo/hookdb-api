package com.winningstation.repository;

import com.winningstation.entity.Game;
import com.winningstation.entity.GameScore;
import com.winningstation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la puntuación que un usuario le da a un juego.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface GameScoreRepository extends JpaRepository<GameScore, Long> {
  GameScore findByUserAndGame(User user, Game game);

  @Modifying
  @Query("DELETE FROM GameScore gs WHERE gs.game.id = :gameId")
  void deleteByGameId(@Param("gameId") Long gameId);

  @Modifying
  @Query("DELETE FROM GameScore gs WHERE gs.game.id = :gameId AND gs.user.id = :userId")
  void deleteByGameIdAndUserId(@Param("gameId") Long gameId, @Param("userId") Long userId);
}
