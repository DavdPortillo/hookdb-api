package com.winningstation.entity;

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
 * Logo del producto
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "vendor_product")
public class VendorProduct implements Serializable {

  /** Id único de la key. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre del producto. */
  @NotNull private String name;
  /** Imagen del logo. */
  @NotNull private String logo;
  @NotNull private String alt;

  @Serial private static final long serialVersionUID = 1L;
}
