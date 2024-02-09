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
@Table(name = "number_player")
public class NumberPlayer implements Serializable {

	/**
	 * ID único de la saga. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Número de jugadores.
	 */
	@NotNull
	private Integer numberPlayers;

	private static final long serialVersionUID = 1L;

}
