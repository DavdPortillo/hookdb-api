package com.winningstation.repository;

import com.winningstation.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Clase que representa los idiomas que tiene un juego.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {

  List<Language> findByNameContaining(String name);
}
