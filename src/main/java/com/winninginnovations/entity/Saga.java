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

/** Clase que representa los juegos que tiene un juego. */
@Data
@Entity
@Table(name = "saga")
public class Saga implements Serializable {

  /** Id único de la saga. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre del juego de la saga. */
  @NotNull private String name;

  @Serial private static final long serialVersionUID = 1L;
}
