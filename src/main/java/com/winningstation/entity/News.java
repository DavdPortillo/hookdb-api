package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

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

  @CreationTimestamp private LocalDateTime date;

  /** Título de la noticia. */
  @NotNull
  @Column(columnDefinition = "TEXT")
  private String headline;

  /** Subtítulo de la noticia. */
  @NotNull
  @Column(columnDefinition = "TEXT")
  private String subtitle;

  /** Imagen de la noticia. */
  @NotNull private String image;

  /** alt de la imagen de la noticia. */
  @NotNull private String alt;

  /** Contenido de la noticia. */
  @NotNull
  @Column(columnDefinition = "TEXT")
  private String content;

  /** Comentarios de la noticia. */
  @JsonIgnore
  @OneToMany(mappedBy = "news", cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<NewsComment> newsComment;

  @NotNull
  @ManyToOne
  @JoinColumn(name = "news_author_id")
  private NewsAuthor newsAuthor;

  /** Noticias del juego. */
  @ManyToOne
  @JoinColumn(
      name = "game_id",
      foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))
  @JsonBackReference("game-news")
  @ToString.Exclude
  private Game game;

  @ManyToOne
  @JoinColumn(name = "translation_id")
  private Translation translation;

  public String getNameGame() {
    return game == null ? null : game.getTitle();
  }

  public Long getIdGame() {
    return game == null ? null : game.getId();
  }

  public Integer getCommentCount() {
    return newsComment == null ? 0 : newsComment.size();
  }

}
