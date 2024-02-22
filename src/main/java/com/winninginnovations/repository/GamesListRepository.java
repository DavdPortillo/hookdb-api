package com.winninginnovations.repository;

import com.winninginnovations.entity.GamesList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la lista de juegos.
 *
 * @author David
 */
@Repository
public interface GamesListRepository extends JpaRepository<GamesList, Long> {}
