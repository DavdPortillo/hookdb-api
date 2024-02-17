package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa los juegos que tiene un juego.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "availability")
public class Availability implements Serializable {

  /** Id unido del lenguaje. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Idioma de la interfaz. */
  @NotNull private String interfaceLanguage;

  /** Idioma de los subtítulos. */
  @NotNull private String subtitleLanguage;

  /** Idioma del audio. */
  @NotNull private String audioLanguage;

  /** El lenguaje asociado con esta disponibilidad. */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "language_id")
  @JsonBackReference
  private Language language;

  /** El juego asociado con esta disponibilidad. */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "game_id")
  @JsonBackReference
  private Game game;

  @Serial private static final long serialVersionUID = 1L;
}
