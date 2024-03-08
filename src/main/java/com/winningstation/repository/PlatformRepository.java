package com.winningstation.repository;

import com.winningstation.entity.Platform;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para las plataformas.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface PlatformRepository extends JpaRepository<Platform, Long> {

  List<Platform> findAllById(Iterable<Long> ids);

  List<Platform> findByNameContaining(String name);
}
