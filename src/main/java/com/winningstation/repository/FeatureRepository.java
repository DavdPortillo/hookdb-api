package com.winningstation.repository;

import com.winningstation.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de las características de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {


    List<Feature> findByNameContaining(String name);
}
