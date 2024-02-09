package com.winninginnovations.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa a una key del juego
 * 
 */
@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * ID único de la key. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Precio de la key.
	 */
	@NotNull
	private Double price;

	/**
	 * Link de la key.
	 */
	@NotNull
	private String link;

	/**
	 * Logo del producto.
	 */
	@OneToOne
	@JoinColumn(name = "logo_product_id")
	private LogoProduct logoProduct;

	/**
	 * Edicion del producto.
	 */
	@OneToOne
	@JoinColumn(name = "edition_product_id")
	private EditionProduct editionProduct;

	/**
	 * Plataforma del producto.
	 */
	@OneToOne
	@JoinColumn(name = "platform_product_id")
	private PlatformProduct platformProduct;

	/**
	 * Vendor del producto.
	 */
	@OneToOne
	@JoinColumn(name = "vendor_product_id")
	private VendorProduct vendorProduct;

	/**
	 * Region del producto.
	 */
	@OneToOne
	@JoinColumn(name = "region_product_id")
	private RegionProduct regionProduct;

	/**
	 * Keys del producto.
	 */
	@OneToOne
	@JoinColumn(name = "keys_product_id")
	private KeysProduct keysProduct;

	private static final long serialVersionUID = 1L;

}
