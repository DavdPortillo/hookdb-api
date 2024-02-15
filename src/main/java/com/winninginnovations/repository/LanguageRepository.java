package com.winninginnovations.repository;

import com.winninginnovations.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Clase que representa los idiomas que tiene un juego.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {}
