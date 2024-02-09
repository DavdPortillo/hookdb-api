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
 * Edicion de producto
 * 
 */
@Data
@Entity
@Table(name = "edition_product")
public class EditionProduct implements Serializable {

	/**
	 * ID único de la edicion. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre de la edicion.
	 */
	@NotNull
	private String name;

	private static final long serialVersionUID = 1L;

}
