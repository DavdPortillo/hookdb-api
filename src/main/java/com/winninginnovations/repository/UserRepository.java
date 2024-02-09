package com.winninginnovations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.winninginnovations.entity.User;

/**
 * Repositorio de usuario. Extiende de JpaRepository para para proporcionar
 * métodos CRUD para la entidad Language.
 * 
 * @author David Portillo Hoyos
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
