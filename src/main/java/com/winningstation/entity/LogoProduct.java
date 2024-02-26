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
@Table(name = "logo_product")
public class LogoProduct implements Serializable {

  /** Id único de la key. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Imagen del logo. */
  @NotNull private String logo;

  @Serial private static final long serialVersionUID = 1L;
}
