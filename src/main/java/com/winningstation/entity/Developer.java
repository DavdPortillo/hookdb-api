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

/** Clase que representa a un desarrollador del juego. */
@Data
@Entity
@Table(name = "developer")
public class Developer implements Serializable {

  /** Id único del desarrollador. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre del desarrollador. */
  @NotNull private String name;

  @Serial private static final long serialVersionUID = 1L;
}
