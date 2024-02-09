package com.winninginnovations.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Clase que representa los juegos que tiene un juego.
 * 
 */
@Data
@Entity
@Table(name = "crossplay")
public class Crossplay implements Serializable {

	/**
	 * ID único de la saga. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Tiene crossplay.
	 */
	private boolean hasCrossplay;

	private static final long serialVersionUID = 1L;

}
