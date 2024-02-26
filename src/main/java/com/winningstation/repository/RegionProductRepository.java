package com.winningstation.repository;

import com.winningstation.entity.RegionProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de la región del producto.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface RegionProductRepository extends JpaRepository<RegionProduct, Long> {}
