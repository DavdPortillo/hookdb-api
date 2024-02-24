package com.winninginnovations.repository;

import com.winninginnovations.entity.LogoProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la entidad LogoProduct.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface LogoProductRepository extends JpaRepository<LogoProduct, Long> {}
