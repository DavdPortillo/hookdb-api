package com.winninginnovations.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
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
 * Clase que representa una critica hecha por un usuario de una noticia.
 * 
 */
@Data
@Entity
@Table(name = "review")
public class Review implements Serializable {

	/**
	 * ID único del comentario. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Titulo del comentario. No puede ser nulo.
	 */
	@NotNull
	@Size(min = 2, max = 60)
	private String title;

	/**
	 * Contenido del comentario. No puede ser nulo.
	 */
	@NotNull
	@Size(min = 2, max = 5000)
	private String content;

	/**
	 * Date del comentario. No puede ser nulo.
	 */
	@NotNull
	private String date;

	/**
	 * Like del comentario.
	 */
	@Column(name = "`like`")
	private int like;

	/**
	 * Dislike del comentario.
	 */
	private int dislike;

	/**
	 * Juego al que pertenece el comentario. No puede ser nulo.
	 */
	@ManyToOne
	@JoinColumn(name = "game_id")
	@NotNull
	private Game game;

	private static final long serialVersionUID = 1L;

}
