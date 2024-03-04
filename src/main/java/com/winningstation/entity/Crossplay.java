package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa los juegos que tiene un juego.
 * 
 */
@Data
@Entity
@Table(name = "crossplay")
public class Crossplay implements Serializable {

	/**
	 * Id único de la saga. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Tiene crossplay.
	 */
	private Boolean hasCrossplay;

	@Serial
	private static final long serialVersionUID = 1L;

}
