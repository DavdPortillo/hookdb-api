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
 * Clase que representa el voto de un usuario a una critica.
 * 
 */
@Data
@Entity
@Table(name = "review_vote")
public class ReviewVote implements Serializable {

	/**
	 * ID único del voto. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Voto del usuario.
	 */
	@NotNull
	private String vote;

	private static final long serialVersionUID = 1L;

}
