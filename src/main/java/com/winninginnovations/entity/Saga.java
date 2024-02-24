package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "saga")
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Saga implements Serializable {

  /** Id único de la saga. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre de la saga. */
  @NotNull private String name;

  /** Juegos de la saga. */
  @OneToMany(mappedBy = "saga", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<Game> games = new ArrayList<>();

  @Serial private static final long serialVersionUID = 1L;
}
