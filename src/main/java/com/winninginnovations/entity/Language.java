package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.*;
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
@Table(name = "language")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "name")
public class Language implements Serializable {

  /** Id unido del lenguaje. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre del lenguaje. */
  @NotNull private String name;

  /** La disponibilidad del lenguaje. */
  @OneToMany(mappedBy = "language", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Availability> availability;

  @Serial private static final long serialVersionUID = 1L;
}
