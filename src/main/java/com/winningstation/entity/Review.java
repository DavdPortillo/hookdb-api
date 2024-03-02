package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Clase que representa una crítica hecha por un usuario de una noticia.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "review")
public class Review implements Serializable {

  /** Id único del comentario. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Título del comentario. No puede ser nulo. */
  @NotNull
  @Size(min = 2, max = 60)
  private String title;

  /** Contenido del comentario. No puede ser nulo. */
  @NotNull
  @Size(min = 2, max = 5000)
  private String content;

  /** Fecha de creación del comentario. */
  @CreationTimestamp private LocalDateTime date;

  /** Like del comentario. */
  @Column(name = "`like`")
  private Integer like;

  /** Dislike del comentario. */
  private Integer dislike;

  /** Juego al que pertenece el comentario. No puede ser nulo. */
  @ManyToOne
  @JoinColumn(name = "game_id")
  @NotNull
  @JsonBackReference("game-review")
  private Game game;

  /** Usuario que hizo el comentario. No puede ser nulo. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ReviewVote> votes;

  @Serial private static final long serialVersionUID = 1L;
}
