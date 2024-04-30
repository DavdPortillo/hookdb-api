package com.winningstation.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Clase que representa la relación entre un juego y sus características.
 *
 * @author David Portillo Hoyos
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Entity
@Table(name = "game_feature")
public class GameFeature implements Serializable {

  /** Id único de la relación juego-característica. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Juego. */
  @ManyToOne
  @JoinColumn(name = "game_id")
  @JsonBackReference("game-feature")
  @ToString.Exclude
  private Game game;

  /** Característica. */
  @ManyToOne
  @JoinColumn(name = "feature_id")
//  @JsonBackReference("feature")
//  @ToString.Exclude
  private Feature feature;

  /** Número de jugadores de las características. */
  @ManyToOne
  @JoinColumn(name = "number_player_id")
  @JsonBackReference("numberPlayer")
  private NumberPlayer numberPlayers;

  /**
   * Obtiene el nombre de la característica.
   *
   * @return Nombre de la característica.
   */
  @JsonProperty("featureName")
  public String getFeatureName() {
    return this.feature.getName();
  }

  /**
   * Obtiene id del número de jugadores.
   *
   * @return Id del número de jugadores.
   */
  @JsonProperty("numberPlayerId")
  public Long getNumberPlayerId() {
    return this.numberPlayers != null ? this.numberPlayers.getId() : null;
  }

  @Serial private static final long serialVersionUID = 1L;
}
