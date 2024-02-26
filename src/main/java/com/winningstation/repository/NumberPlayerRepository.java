package com.winningstation.repository;

import com.winningstation.entity.NumberPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de las características de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface NumberPlayerRepository extends JpaRepository<NumberPlayer, Long> {}
