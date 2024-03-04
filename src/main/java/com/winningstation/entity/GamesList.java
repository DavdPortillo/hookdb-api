package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/** Clase que representa a una lista de juegos que le pertenecen a un usuario. */
@Data
@Entity
@Table(name = "gameslist")
public class GamesList implements Serializable {

  /** Id único de la lista de juegos. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre de la lista de juegos. No puede ser nulo y debe tener entre 2 y 50 caracteres. */
  @NotNull
  @Size(min = 2, max = 50)
  private String name;

  /** Fecha de creación del comentario. */
  @CreationTimestamp private LocalDateTime date;

  /** Juego al que pertenece la lista de juegos. No puede ser nulo. */
  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

  /** Juegos que pertenecen a la lista de juegos. */
  @ManyToMany
  @JoinTable(
      name = "gameslist_game",
      joinColumns = @JoinColumn(name = "gameslist_id"),
      inverseJoinColumns = @JoinColumn(name = "game_id"))
  @JsonIgnore
  private List<Game> games;

  /** */
  @Serial private static final long serialVersionUID = 1L;
}