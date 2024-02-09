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
 * Clase que a los distribuidores de los juegos.
 * 
 */
@Data
@Entity
@Table(name = "distributor")
public class Distributor implements Serializable {

	/**
	 * ID único del distribuidor. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del distribuidor.
	 */
	@NotNull
	private String name;

	private static final long serialVersionUID = 1L;

}
