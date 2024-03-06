package com.winningstation.repository;

import com.winningstation.entity.LogoProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio de la entidad LogoProduct.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface LogoProductRepository extends JpaRepository<LogoProduct, Long> {

  List<LogoProduct> findByLogoContaining(String name);
}
