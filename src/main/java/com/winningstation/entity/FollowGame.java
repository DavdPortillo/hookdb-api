package com.winningstation.entity;

import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa el seguimiento de un juego por parte de un usuario.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "follow_game")
@JsonSerialize(using = FollowGameSerializer.class)
public class FollowGame implements Serializable {

  /** Id único del seguimiento. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Seguimiento del usuario. */
  private Integer isFollowing = 0;

  /** Juego al que pertenece el seguimiento. No puede ser nulo. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "game_id")
  @JsonBackReference("game-follow-user")
  private Game game;

  /** Usuario al que pertenece el seguimiento. No puede ser nulo. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "user_id")
  @JsonBackReference("user-follow-game")
  private User user;

  /** Id único del seguimiento. Generado automáticamente. */
  @Serial private static final long serialVersionUID = 1L;
}

class FollowGameSerializer extends StdSerializer<FollowGame> {

  public FollowGameSerializer() {
    this(null);
  }

  public FollowGameSerializer(Class<FollowGame> t) {
    super(t);
  }

  @Override
  public void serialize(FollowGame followGame, JsonGenerator jgen, SerializerProvider provider)
      throws IOException {

    jgen.writeStartObject();
    jgen.writeNumberField("id", followGame.getId());
    jgen.writeNumberField("isFollowing", followGame.getIsFollowing());

    Game game = followGame.getGame();
    jgen.writeNumberField("gameId", game.getId());
    jgen.writeStringField("gameName", game.getTitle());

    jgen.writeEndObject();
  }
}
