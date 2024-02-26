package com.winningstation.repository;

import com.winningstation.entity.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad News. Extiende JpaRepository para proporcionar
 * métodos CRUD para la entidad News.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
}
