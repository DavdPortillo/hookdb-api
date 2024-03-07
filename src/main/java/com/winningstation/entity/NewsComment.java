package com.winningstation.entity;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

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

/** Clase que representa a un comentario hecho por un usuario de una noticia. */
@Data
@Entity
@Table(name = "news_comment")
@JsonSerialize(using = NewsCommentSerializer.class)
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

class NewsCommentSerializer extends StdSerializer<NewsComment> {

  public NewsCommentSerializer() {
    this(null);
  }

  public NewsCommentSerializer(Class<NewsComment> t) {
    super(t);
  }

  @Override
  public void serialize(NewsComment newsComment, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {

    jgen.writeStartObject();
    jgen.writeNumberField("id", newsComment.getId());
    jgen.writeStringField("content", newsComment.getContent());
    jgen.writeStringField("date", newsComment.getDate().toString());

    // Usuario
    User user = newsComment.getUser();
    jgen.writeObjectFieldStart("user");
    jgen.writeStringField("image", user.getImage());
    jgen.writeStringField("alt", user.getAlt());
    jgen.writeStringField("username", user.getUsername());
    jgen.writeEndObject();

    jgen.writeEndObject();
  }
}
