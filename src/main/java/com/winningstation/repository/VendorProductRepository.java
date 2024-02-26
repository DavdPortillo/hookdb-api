package com.winningstation.repository;

import com.winningstation.entity.VendorProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de los vendors.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface VendorProductRepository extends JpaRepository<VendorProduct, Long> {}
