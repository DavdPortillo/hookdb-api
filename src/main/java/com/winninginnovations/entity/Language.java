package com.winninginnovations.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa los juegos que tiene un juego.
 * 
 */
@Data
@Entity
@Table(name = "language")
public class Language implements Serializable {

	/**
	 * ID unido del lenguaje. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del lenguaje.
	 */
	@NotNull
	private String name;

	/**
	 * Juegos que tienen el lenguaje.
	 */
	@OneToMany
	@JoinColumn(name = "availability_id")
	private List<Availability> availability;

	private static final long serialVersionUID = 1L;

}
