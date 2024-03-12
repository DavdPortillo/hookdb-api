package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/** Clase que representa a un juego del sistema. */
@Data
@Entity
@Table(name = "game")
public class Game implements Serializable {

  /** Id único del juego. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre del juego. */
  @NotNull private String title;

  /** Imagen del juego. */
  @NotNull private String cover;

  /** alt de la imagen del juego. */
  @NotNull private String alt;

  /** Año de lanzamiento del juego. */
  @NotNull private LocalDate date;

  /** Trailer del juego. */
  @NotNull private String trailer;

  /** Popularidad del juego. */
  @NotNull private Long popularity = 0L;

  /** Sinopsis del juego. */
  @NotNull
  @Column(columnDefinition = "TEXT")
  private String sinopsis;

  /** Tiempo de juego de la historia del juego. */
  @NotNull private Double storyTime;

  /** Tiempo de completar el juego al 100%. */
  @NotNull private Double completeTime;

  /** Géneros del juego */
  @NotNull
  @ManyToMany
  @JoinTable(
      name = "game_genre",
      joinColumns = @JoinColumn(name = "game_id"),
      inverseJoinColumns = @JoinColumn(name = "genre_id"))
  private List<Genre> genres;

  /** Desarrollador del juego. */
  @NotNull
  @ManyToMany
  @JoinTable(
      name = "game_developer",
      joinColumns = @JoinColumn(name = "game_id"),
      inverseJoinColumns = @JoinColumn(name = "developer_id"))
  private List<Developer> developers;

  /** Distribuidor del juego. */
  @NotNull
  @ManyToMany
  @JoinTable(
      name = "game_distributor",
      joinColumns = @JoinColumn(name = "game_id"),
      inverseJoinColumns = @JoinColumn(name = "distributor_id"))
  private List<Distributor> distributors;

  /** Requisitos mínimos del sistema. */
  @NotNull
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "minimum_system_requirement_id")
  private SystemRequirement minimumSystemRequirement;

  /** Requisitos recomendados del sistema. */
  @NotNull
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "recommended_system_requirement_id")
  private SystemRequirement recommendedSystemRequirement;

  /** Key del juego. */
  @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Product> products;

  /** Plataformas en las que está disponible el juego. */
  @NotNull
  @ManyToMany
  @JoinTable(
      name = "game_platform",
      joinColumns = @JoinColumn(name = "game_id"),
      inverseJoinColumns = @JoinColumn(name = "platform_id"))
  private List<Platform> platforms;

  /** Dlcs del juego. */
  @JsonManagedReference("game-dlc")
  @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<DLC> dlcs;

  @NotNull
  @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference(value = "game-availability")
  private List<Availability> availabilities;

  /** Características del juego. */
  @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference("game-feature")
  private List<GameFeature> gameFeatures;

  /** Noticias del juego. */
  @OneToMany(mappedBy = "game",cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
  @JsonManagedReference("game-news")
  @JsonIgnore
  private List<News> news = new ArrayList<>();

  /** Críticas hechas por los usuarios. */
  @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<Review> reviews = new ArrayList<>();

  /** Listas de juegos. */
  @ManyToMany(mappedBy = "games")
  @JsonIgnore
  private List<GamesList> gamesLists;

  /** Puntuaciones del juego. */
  @OneToMany(mappedBy = "game", cascade = CascadeType.REMOVE, orphanRemoval = true)
  @JsonIgnore
  private List<GameScore> gameScores;

  /** Saga a la que pertenece el juego. */
  @ManyToOne
  @JoinColumn(name = "saga_id")
  @JsonBackReference("saga-game")
  private Saga saga;

  /** Usuarios que siguen o ignoran el juego. */
  @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
  @JsonManagedReference("game-follow-user")
  @JsonIgnore
  private List<FollowGame> followGames;

  /** Tiene Cross play. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "crossplay_id")
  private Crossplay crossplay;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "translation_id")
  private Translation translation;



  public int getReviewCount() {
    return reviews.size();
  }

  public int getNewsCommentCount() {
    return news.stream()
            .mapToInt(n -> n.getNewsComment().size())
            .sum();
  }


  @Serial private static final long serialVersionUID = 1L;
}
