package com.winningstation.repository;

import com.winningstation.entity.EditionProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio para la entidad EditionProduct.
 *
 * @author David Portillo Hoyos
 */
public interface EditionProductRepository extends JpaRepository<EditionProduct, Long> {

    List<EditionProduct> findByNameContaining(String name);
}
