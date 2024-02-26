package com.winningstation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.winningstation.entity.Game;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de Game. Extiende de JpaRepository para para proporcionar métodos
 * CRUD para la entidad Game.
 * 
 * @author David Portillo Hoyos
 * 
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
