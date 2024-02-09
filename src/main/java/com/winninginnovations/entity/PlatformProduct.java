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
 * Clase que representa a una plataforma de un producto.
 * 
 */
@Data
@Entity
@Table(name = "platform_product")
public class PlatformProduct implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID único de la key. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre de la plataforma.
	 */
	@NotNull
	private String name;

	/**
	 * Imagen de la plataforma.
	 */
	@NotNull
	private String image;

}
