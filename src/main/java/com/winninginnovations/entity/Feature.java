package com.winninginnovations.entity;

import java.io.Serial;
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
 * Clase que representa las características de un juego.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "feature")
public class Feature implements Serializable {

  /** Id único de las características. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre de las características. */
  @NotNull private String name;

  /** Número de jugadores de las características. */
  @OneToOne
  @JoinColumn(name = "number_player_id")
  private NumberPlayer numberPlayers;

  @Serial private static final long serialVersionUID = 1L;
}
