package com.winningstation.repository;

import com.winningstation.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad News. Extiende JpaRepository para proporcionar métodos CRUD para la
 * entidad News.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

  /**
   * Método que permite obtener las noticias de los juegos seguidos por un usuario.
   *
   * @param userId Id del usuario.
   * @return Lista de noticias de los juegos seguidos por el usuario.
   */
  @Query(
      "SELECT n FROM News n WHERE n.game IN (SELECT f.game FROM FollowGame f WHERE f.user.id = :userId AND f.isFollowing = 1)")
  List<News> findNewsFromFollowedGames(@Param("userId") Long userId);

  @Query("SELECT n FROM News n WHERE n.game NOT IN (SELECT f.game FROM FollowGame f WHERE f.user.id = :userId AND f.isFollowing = -1)")
  List<News> findNewsExceptUnfollowedGames(@Param("userId") Long userId);
}
