package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
	 * ID único de la saga. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Tiene crossplay.
	 */
	private String hasCrossplay;

	@Serial
	private static final long serialVersionUID = 1L;

}
