package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

  @JsonIgnore
  @OneToMany(mappedBy = "feature")
  private List<GameFeature> gameFeatures;

  @Serial private static final long serialVersionUID = 1L;
}
