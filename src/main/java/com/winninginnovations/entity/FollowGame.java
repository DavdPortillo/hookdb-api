package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa el seguimiento de un juego por parte de un usuario.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "follow_game")
public class FollowGame implements Serializable {

  /** Id único del seguimiento. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Seguimiento del usuario. */
  private String isFollowing;

  /** Juego al que pertenece el seguimiento. No puede ser nulo. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "game_id")
  private Game game;

  /** Id único del seguimiento. Generado automáticamente. */
  @Serial private static final long serialVersionUID = 1L;
}
