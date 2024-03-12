package com.winningstation.repository;

import com.winningstation.dto.NewsDTO;
import com.winningstation.entity.News;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
      "SELECT n FROM News n WHERE n.game IN (SELECT f.game FROM FollowGame f WHERE f.user.id = :userId AND f.isFollowing = 1) AND n.translation.id = :translationId")
  List<News> findNewsFromFollowedGamesAndTranslationId(
      @Param("userId") Long userId, @Param("translationId") Long translationId);

  @Query(
      "SELECT n FROM News n WHERE n.game NOT IN (SELECT f.game FROM FollowGame f WHERE f.user.id = :userId AND f.isFollowing = -1) AND n.translation.id = :translationId")
  List<News> findNewsExceptUnfollowedGamesAndTranslationId(
      @Param("userId") Long userId, @Param("translationId") Long translationId);

  @Modifying
  @Query(value = "UPDATE news SET game_id = NULL WHERE game_id = :gameId", nativeQuery = true)
  void setGameIdToNullByGameId(@Param("gameId") Long gameId);

  @Query(
      "SELECT new com.winningstation.dto.NewsDTO(n.id,n.image,n.alt, n.headline, n.newsAuthor.name,n.newsAuthor.surname, size(n.newsComment), n.date) "
          + "FROM News n "
          + "WHERE n.translation.id = :translationId "
          + "ORDER BY n.date DESC")
  List<NewsDTO> findLatestNewsWithSelectedFieldsAndTranslationId(
      Pageable pageable, @Param("translationId") Long translationId);

  List<News> findByTranslationId(Long translationId);
}
