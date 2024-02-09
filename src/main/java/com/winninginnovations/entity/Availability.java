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
 * Clase que representa los juegos que tiene un juego.
 * 
 */
@Data
@Entity
@Table(name = "availability")
public class Availability implements Serializable {

	/**
	 * ID unido del lenguaje. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Idioma de la interfaz.
	 */
	@NotNull
	private String interfaceLanguage;

	/**
	 * Idioma de los subtítulos.
	 */
	@NotNull
	private String subtitleLanguage;

	/**
	 * Idioma del audio.
	 */
	@NotNull
	private String audioLanguage;

	private static final long serialVersionUID = 1L;
}
