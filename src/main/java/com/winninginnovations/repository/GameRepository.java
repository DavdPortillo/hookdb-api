package com.winninginnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.winninginnovations.entity.Game;

/**
 * Repositorio de Game. Extiende de JpaRepository para para proporcionar métodos
 * CRUD para la entidad Game.
 * 
 * @author David Portillo Hoyos
 * 
 */
public interface GameRepository extends JpaRepository<Game, Long> {

}
