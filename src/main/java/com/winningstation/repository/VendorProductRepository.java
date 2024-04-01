package com.winningstation.repository;

import com.winningstation.entity.VendorProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de la entidad LogoProduct.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface VendorProductRepository extends JpaRepository<VendorProduct, Long> {

  List<VendorProduct> findByNameContaining(String name);
}
