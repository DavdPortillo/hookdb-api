package com.winninginnovations.repository;

import com.winninginnovations.entity.VendorProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de los vendors.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface VendorProductRepository extends JpaRepository<VendorProduct, Long> {}
