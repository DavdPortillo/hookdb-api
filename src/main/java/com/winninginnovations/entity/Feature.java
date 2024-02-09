package com.winninginnovations.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa las caracteristicas de un juego.
 * 
 */
@Data
@Entity
@Table(name = "feature")
public class Feature implements Serializable {

	/**
	 * ID unico de las caracteristicas. Generado automaticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre de las caracteristicas.
	 */
	@NotNull
	private String name;

	/**
	 * Numero de jugadores de las caracteristicas.
	 */
	@OneToOne
	@JoinColumn(name = "number_player_id")
	private NumberPlayer numberPlayers;

	private static final long serialVersionUID = 1L;

}
