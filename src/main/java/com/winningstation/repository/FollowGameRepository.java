package com.winningstation.repository;

import com.winningstation.entity.FollowGame;
import com.winningstation.entity.Game;
import com.winningstation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para el seguimiento de juegos. *
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface FollowGameRepository extends JpaRepository<FollowGame, Long> {

  FollowGame findByUserAndGame(User user, Game game);
}
