package com.winninginnovations.repository;

import com.winninginnovations.entity.EditionProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio para la entidad EditionProduct.
 *
 * @author David Portillo Hoyos
 */
public interface EditionProductRepository extends JpaRepository<EditionProduct, Long> {}
