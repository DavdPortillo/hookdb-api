package com.winningstation.repository;

import com.winningstation.entity.Game;
import com.winningstation.entity.GameScore;
import com.winningstation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la puntuación que un usuario le da a un juego.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface GameScoreRepository extends JpaRepository<GameScore, Long> {
  GameScore findByUserAndGame(User user, Game game);
}
