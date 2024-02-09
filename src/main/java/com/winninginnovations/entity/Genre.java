package com.winninginnovations.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa a un genero de juego del sistema.
 * 
 */
@Data
@Entity
@Table(name = "genre")
public class Genre implements Serializable {

	/**
	 * ID único del genero de juego. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del genero de juego.
	 */
	@NotNull
	private String name;

	private static final long serialVersionUID = 1L;

}
