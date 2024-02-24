package com.winninginnovations.repository;

import com.winninginnovations.entity.PlatformProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio de la entidad Producto de Plataforma.
 *
 * @author David Portillo Hoyos
 */
public interface PlatformProductRepository extends JpaRepository<PlatformProduct, Long> {}
