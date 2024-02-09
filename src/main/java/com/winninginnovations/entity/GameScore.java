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
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Clase que representa la puntuación que un usuario le da a un juego.
 * 
 */
@Data
@Entity
@Table(name = "game_score")
public class GameScore implements Serializable {

	/**
	 * ID único del comentario. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Date de la puntuación. No puede ser nulo.
	 */
	@NotNull
	private String date;

	/**
	 * Puntuación que da el usuario al juego.
	 */
	@NotNull
	@Size(min = 0, max = 10)
	private Integer score;
	
	/**
	 * Juego al que pertenece la puntuación. No puede ser nulo.
	 */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "game_id")
	private Game game;

	private static final long serialVersionUID = 1L;

}
