package com.winninginnovations.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Clase que representa los dlcs que tiene un juego.
 * 
 */
@Data
@Entity
@Table(name = "dlc")
public class DLC implements Serializable {

	/**
	 * ID único del dlc. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private static final long serialVersionUID = 1L;

}
