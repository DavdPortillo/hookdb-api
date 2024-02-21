package com.winninginnovations.repository;

import com.winninginnovations.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de las características de los juegos.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {}
