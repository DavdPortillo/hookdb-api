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
 * Edición de producto
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "edition_product")
public class EditionProduct implements Serializable {

  /** Id único de la edición. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre de la edición. */
  @NotNull private String name;

  @Serial private static final long serialVersionUID = 1L;
}
