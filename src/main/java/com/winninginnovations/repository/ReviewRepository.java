package com.winninginnovations.repository;

import com.winninginnovations.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** Clase que representa el repositorio de las críticas. */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {}
