package com.winninginnovations.repository;

import com.winninginnovations.entity.FollowGame;
import com.winninginnovations.entity.Game;
import com.winninginnovations.entity.User;
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
