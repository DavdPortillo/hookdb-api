package com.winningstation.repository;

import com.winningstation.entity.Saga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de las sagas de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface SagaRepository extends JpaRepository<Saga, Long> {}
