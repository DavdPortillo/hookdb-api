package com.winningstation.repository;

import com.winningstation.entity.NewsComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad NewsComment. Extiende JpaRepository para proporcionar
 * métodos CRUD para la entidad NewsComment.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface NewsCommentRepository extends JpaRepository<NewsComment, Long> {
}
