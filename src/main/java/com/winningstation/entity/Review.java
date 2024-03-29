package com.winningstation.entity;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
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
@JsonSerialize(using = ReviewSerializer.class)
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
  @Size(min = 2, max = 1000)
  private String content;

  /** Fecha de creación del comentario. */
  @CreationTimestamp private LocalDateTime date;

  /** Like del comentario. */
  @Column(name = "`like`")
  private Integer like = 0;

  /** Dislike del comentario. */
  private Integer dislike = 0;

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

  @JsonIgnore
  @OneToMany(mappedBy = "review", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ReviewVote> votes;

  @Serial private static final long serialVersionUID = 1L;
}

class ReviewSerializer extends StdSerializer<Review> {

  public ReviewSerializer() {
    this(null);
  }

  public ReviewSerializer(Class<Review> t) {
    super(t);
  }

  @Override
  public void serialize(Review review, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {

    jgen.writeStartObject();
    jgen.writeNumberField("id", review.getId());
    jgen.writeStringField("title", review.getTitle());
    jgen.writeStringField("content", review.getContent());
    jgen.writeStringField("date", review.getDate().toString());

    // Usuario
    User user = review.getUser();
    jgen.writeObjectFieldStart("user");
    jgen.writeStringField("image", user.getImage());
    jgen.writeStringField("alt", user.getAlt());
    jgen.writeStringField("username", user.getUsername());
    jgen.writeNumberField("gameScoresCount", user.getGameScores().size());
    jgen.writeNumberField("reviewsCount", user.getReviews().size());
    jgen.writeEndObject();

    // Buscar la puntuación del juego
    GameScore gameScore =
        user.getGameScores().stream()
            .filter(score -> score.getGame().equals(review.getGame()))
            .findFirst()
            .orElse(null);
    if (gameScore != null) {
      jgen.writeNumberField("gameScore", gameScore.getScore());
    }

    jgen.writeEndObject(); // Fin del objeto 'user'
  }
}
