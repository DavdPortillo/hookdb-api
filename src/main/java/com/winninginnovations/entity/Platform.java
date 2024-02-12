package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa para que plataforma está disponible un juego.
 * 
 */
@Data
@Entity
@Table(name = "platform")
public class Platform implements Serializable {

	/**
	 * Id único de la plataforma. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre de la plataforma.
	 */
	@NotNull
	private String name;

	@Serial
	private static final long serialVersionUID = 1L;

}
