package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

/**
 * Clase que representa a una key del juego
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "product")
public class Product implements Serializable {

  /** Id único de la key. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Precio de la key. */
  @NotNull private Double price;

  /** Link de la key. */
  @NotNull private String link;

  /** Logo del producto. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "logo_product_id")
  private LogoProduct logoProduct;

  /** Edición del producto. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "edition_product_id")
  private EditionProduct editionProduct;

  /** Plataforma del producto. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "platform_product_id")
  private PlatformProduct platformProduct;

  /** Vendor del producto. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "vendor_product_id")
  private VendorProduct vendorProduct;

  /** Región del producto. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "region_product_id")
  private RegionProduct regionProduct;

  /** Keys del producto. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "keys_product_id")
  private KeysProduct keysProduct;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "game_id")
  @JsonIgnore
  @ToString.Exclude
  private Game game;

  @Serial private static final long serialVersionUID = 1L;
}
