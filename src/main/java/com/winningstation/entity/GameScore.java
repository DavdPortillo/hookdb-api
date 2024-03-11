package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Clase que representa la puntuación que un usuario le da a un juego.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(
    name = "game_score",
    uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "game_id"}))
public class GameScore implements Serializable {

  /** Id único del comentario. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Fecha en la que se hizo la puntuación. */
 @NotNull private LocalDateTime date;

  /** Puntuación que da el usuario al juego. */
  @Min(0)
  @Max(10)
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private Integer score;

  /** Usuario que puntuó el juego. */
  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonBackReference("user-score")
  private User user;

  /** Juego que fue puntuado. */
  @ManyToOne
  @JoinColumn(name = "game_id")
  @JsonBackReference("game-score")
  private Game game;

  @Serial private static final long serialVersionUID = 1L;
}
