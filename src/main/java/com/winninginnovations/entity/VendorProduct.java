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
 * Clase que representa a un producto de un vendedor.
 * 
 */
@Data
@Entity
@Table(name = "vendor_product")
public class VendorProduct implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ID único de la key. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del producto.
	 */
	@NotNull
	private String name;

}
