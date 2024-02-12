package com.winninginnovations.repository;

import com.winninginnovations.entity.NewsAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad NewsAuthor. Extiende JpaRepository para proporcionar
 * métodos CRUD para la entidad NewsAuthor.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface NewsAuthorRepository extends JpaRepository<NewsAuthor, Long> {
}
