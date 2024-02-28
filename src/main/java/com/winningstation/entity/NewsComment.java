package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/** Clase que representa a un comentario hecho por un usuario de una noticia. */
@Data
@Entity
@Table(name = "news_comment")
public class NewsComment implements Serializable {

  /** Id único del comentario. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Contenido del comentario. No puede ser nulo. */
  @NotNull
  @Size(min = 2, max = 2000)
  private String content;

  @CreationTimestamp private LocalDateTime date;

  /** Noticia a la que pertenece el comentario. No puede ser nulo. */
  @JsonIgnore
  @NotNull
  @ManyToOne
  @JoinColumn(name = "news_id")
  private News news;

  /** Usuario que hizo el comentario. No puede ser nulo. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Serial private static final long serialVersionUID = 1L;
}
