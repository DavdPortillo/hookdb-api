package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/** Clase que representa los dlcs que tiene un juego. */
@Data
@Entity
@Table(name = "dlc")
public class DLC implements Serializable {

  /** ID único del dlc. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre del dlc. */
  @NotNull private String name;

  /** Juego al que pertenece el dlc. */
  @NotNull
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "game_id")
  private Game game;

  @Serial private static final long serialVersionUID = 1L;
}
