package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.ToString;

/** Clase que representa a un comentario hecho por un usuario de una noticia. */
@Data
@Entity
@Table(name = "news_comment")
public class NewsComment implements Serializable {

  /** ID único del comentario. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Contenido del comentario. No puede ser nulo. */
  @NotNull
  @Size(min = 2, max = 2000)
  private String content;

  @NotNull private LocalDateTime date;

  @PrePersist
  protected void onCreate() {
    ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
    date = zdt.toLocalDateTime();
  }

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
