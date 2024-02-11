package com.winninginnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.winninginnovations.entity.Crossplay;

/**
 * Repositorio de Crossplay. Extiende de JpaRepository para para proporcionar
 * métodos CRUD para la entidad Crossplay.
 * 
 * 
 */
public interface CrossplayRepository extends JpaRepository<Crossplay, Long>{

}
