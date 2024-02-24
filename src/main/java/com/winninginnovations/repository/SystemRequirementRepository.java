package com.winninginnovations.repository;

import com.winninginnovations.entity.SystemRequirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Repositorio de los requerimientos del sistema. */
@Repository
public interface SystemRequirementRepository extends JpaRepository<SystemRequirement, Long> {}
