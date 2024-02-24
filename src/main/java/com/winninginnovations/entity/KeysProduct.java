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
 * Clase que representa a una key del juego
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "keys_product")
public class KeysProduct implements Serializable {

  /** */
  @Serial private static final long serialVersionUID = 1L;

  /** Id único de la key. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre de la key. */
  @NotNull private String name;
}
