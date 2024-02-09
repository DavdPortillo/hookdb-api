package com.winninginnovations.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa el seguimiento de un juego por parte de un usuario.
 * 
 */
@Data
@Entity
@Table(name = "follow_game")
public class FollowGame implements Serializable {

	/**
	 * ID único del seguimiento. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// isFollowing
	/**
	 * Seguimiento del usuario.
	 */
	private String isFollowing;
	
	
	/**
	 * Juego al que pertenece el seguimiento. No puede ser nulo.
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;

	/**
	 * ID único del seguimiento. Generado automáticamente.
	 */
	private static final long serialVersionUID = 1L;

}
