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
 * Clase que representa a una lista de juegos que le pertenecen a un usuario.
 * 
 */
@Data
@Entity
@Table(name = "gameslist")
public class GamesList implements Serializable {

	/**
	 * ID único de la lista de juegos. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre de la lista de juegos. No puede ser nulo y debe tener entre 2 y 50
	 * caracteres.
	 */
	@NotNull
	@Size(min = 2, max = 50)
	private String name;

	/**
	 * date de creación de la lista de juegos.
	 */
	@NotNull
	private String date;
	
	/**
	 * Juego al que pertenece el comentario. No puede ser nulo.
	 */
	@ManyToOne
	@JoinColumn(name = "game_id")
	@NotNull
	private Game game;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
