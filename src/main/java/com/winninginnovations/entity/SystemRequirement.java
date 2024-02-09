package com.winninginnovations.entity;

import java.io.Serializable;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa los requisitos de sistema de un juego.
 * 
 */
@Data
@MappedSuperclass
public abstract class SystemRequirement implements Serializable {

	/**
	 * ID único de los requisitos de sistema. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	/**
	 * Sistema operativo.
	 */
	@NotNull
	private String operatingSystem;
	/**
	 * Procesador.
	 */
	@NotNull
	private String processor;
	/**
	 * Memoria RAM.
	 */
	@NotNull
	private String ram;
	/**
	 * Tarjeta gráfica.
	 */
	@NotNull
	private String graphicsCard;
	/**
	 * versión de DirectX.
	 */
	@NotNull
	private String directX;
	/**
	 * Almacenamiento.
	 */
	@NotNull
	private String storage;

	private static final long serialVersionUID = 1L;

}
