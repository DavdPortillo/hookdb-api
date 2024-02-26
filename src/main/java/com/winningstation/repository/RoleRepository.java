package com.winningstation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.winningstation.entity.Role;

/**
 * Repositorio para la entidad Role. Extiende JpaRepository para proporcionar
 * métodos CRUD para la entidad Role.
 *
 * @author David Portillo Hoyos
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
