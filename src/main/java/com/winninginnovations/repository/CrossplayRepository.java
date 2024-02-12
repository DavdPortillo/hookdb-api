package com.winninginnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.winninginnovations.entity.Crossplay;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de Crossplay. Extiende de JpaRepository para para proporcionar
 * métodos CRUD para la entidad Crossplay.
 * 
 * 
 */
@Repository
public interface CrossplayRepository extends JpaRepository<Crossplay, Long>{

}
