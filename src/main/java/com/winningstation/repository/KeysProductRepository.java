package com.winningstation.repository;

import com.winningstation.entity.KeysProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio de las keys de producto.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface KeysProductRepository extends JpaRepository<KeysProduct, Long> {}