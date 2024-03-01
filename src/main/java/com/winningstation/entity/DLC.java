package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

/** Clase que representa los dlcs que tiene un juego. */
@Data
@Entity
@Table(name = "dlc")
public class DLC implements Serializable {

  /** Id único del dlc. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Año de lanzamiento del dlc */
  @NotNull private LocalDate date;

  /** Sinopsis del dlc. */
  @NotNull
  @Column(columnDefinition = "TEXT")
  private String sinopsis;

  /** Nombre del dlc. */
  @NotNull private String name;

  /** Juego al que pertenece el dlc. */
  @NotNull
  @JsonBackReference("game-dlc")
  @ManyToOne
  @JoinColumn(name = "game_id")
  @ToString.Exclude
  private Game game;

  @Serial private static final long serialVersionUID = 1L;
}
