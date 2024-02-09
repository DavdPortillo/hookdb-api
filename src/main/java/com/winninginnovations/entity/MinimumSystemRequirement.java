package com.winninginnovations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Clase que representa los requerimientos mínimos de un juego.
 * 
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "minimum_system_requirement")
public class MinimumSystemRequirement extends SystemRequirement {

	private static final long serialVersionUID = 1L;

}
