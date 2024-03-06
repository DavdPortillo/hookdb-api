package com.winningstation.repository;

import com.winningstation.entity.PlatformProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repositorio de la entidad Producto de Plataforma.
 *
 * @author David Portillo Hoyos
 */
public interface PlatformProductRepository extends JpaRepository<PlatformProduct, Long> {

  List<PlatformProduct> findByNameContaining(String name);
}
