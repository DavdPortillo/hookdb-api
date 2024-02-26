package com.winningstation.repository;

import com.winningstation.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Genre. Extiende JpaRepository para proporcionar
 * métodos CRUD para la entidad Genre.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
