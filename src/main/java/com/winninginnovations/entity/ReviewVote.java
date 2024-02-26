package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa el voto de un usuario a una crítica.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "review_vote")
public class ReviewVote implements Serializable {

  /** Id único del voto. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Voto del usuario. */
  @NotNull private Integer vote;

  /** Usuario que emitió el voto. No puede ser nulo. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonBackReference("user-review-vote")
  private User user;

  /** Comentario al que se emitió el voto. No puede ser nulo. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "review_id")
  @JsonBackReference
  private Review review;

  @Serial private static final long serialVersionUID = 1L;
}
