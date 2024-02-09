package com.winninginnovations.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa un rol del sistema.
 * 
 */
@Data
@Entity
@Table(name = "role")
public class Role implements Serializable {

	/**
	 * ID para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID único del rol. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del rol. No puede ser nulo y debe ser único.
	 */
	@NotNull
	@Column(unique = true)
	private String name;

	/**
	 * Método para representar el rol como una cadena de texto.
	 *
	 * @return El nombre del rol.
	 */
	@Override
	public String toString() {
		return this.name;
	}
}