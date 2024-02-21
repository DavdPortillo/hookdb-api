package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa una noticia.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "news")
public class News implements Serializable {

  /** Id para la serialización. */
  @Serial private static final long serialVersionUID = 1L;

  /** Id único de la noticia. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull private LocalDateTime date;

  @PrePersist
  protected void onCreate() {
    ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Europe/Madrid"));
    date = zdt.toLocalDateTime();
  }

  /** Título de la noticia. */
  @NotNull
  @Column(columnDefinition = "TEXT")
  private String headline;

  /** Imagen de la noticia. */
  @NotNull private String image;

  /** alt de la imagen de la noticia. */
  @NotNull private String alt;

  /** Contenido de la noticia. */
  @NotNull
  @Column(columnDefinition = "TEXT")
  private String content;

  /** Comentarios de la noticia. */
  @OneToMany(mappedBy = "news")
  private List<NewsComment> newsComment;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "news_author_id")
  private NewsAuthor newsAuthor;

  /** Noticias del juego. */
  @ManyToOne
  @JoinColumn(name = "game_id")
  @JsonBackReference
  private Game game;
}
