package com.winningstation.repository;

import com.winningstation.entity.GameFeature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Repositorio de GameFeature. */
@Repository
public interface GameFeatureRepository extends JpaRepository<GameFeature, Long> {}
