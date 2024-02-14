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
 * Clase que representa los juegos que tiene un juego.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "number_player")
public class NumberPlayer implements Serializable {

  /** Id único de la saga. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Número de jugadores. */
  @NotNull private Integer numberPlayers;

  @Serial private static final long serialVersionUID = 1L;
}
