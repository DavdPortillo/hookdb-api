package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/** Clase que representa a un juego del sistema. */
@Data
@Entity
@Table(name = "game")
public class Game implements Serializable {

  /** ID único del juego. Generado automáticamente. */
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
  @NotNull private String releaseYear;

  /** Trailer del juego. */
  @NotNull private String trailer;

  /** Sinopsis del juego. */
  @NotNull
  @Column(columnDefinition = "TEXT")
  private String sinopsis;

  /** Tiempo de juego de la historia del juego. */
  @NotNull private Double storyTime;

  /** Tiempo de completar el juego al 100%. */
  @NotNull private Double completeTime;

  /** Juegos que sigue el usuario. */
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
  @ManyToOne
  @JoinColumn(name = "minimum_system_requirement_id")
  private MinimumSystemRequirement minimumSystemRequirement;

  /** Requisitos recomendados del sistema. */
  @ManyToOne
  @JoinColumn(name = "recommended_system_requirement_id")
  private RecommendedSystemRequirement recommendedSystemRequirement;

  /** Key del juego. */
  @ManyToOne
  @JoinColumn(name = "product_id")
  private Product product;

  /** Plataformas en las que está disponible el juego. */
  @NotNull
  @ManyToMany
  @JoinTable(
      name = "game_platform",
      joinColumns = @JoinColumn(name = "game_id"),
      inverseJoinColumns = @JoinColumn(name = "platform_id"))
  private List<Platform> platforms;

  /** Dlcs del juego. */
  @JsonManagedReference
  @OneToMany(mappedBy = "game")
  private List<DLC> dlcs;

  @NotNull
  @OneToMany(mappedBy = "game", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference(value = "game-availability")
  private List<Availability> availabilities;

  /** Características del juego. */
  @OneToMany(mappedBy = "game")
  @JsonManagedReference("game")
  private List<GameFeature> gameFeatures;

  /** Noticias del juego. */
  @OneToMany(mappedBy = "game")
  @JsonManagedReference
  private List<News> news;

  /** Críticas hechas por los usuarios. */
  @OneToMany(mappedBy = "game" , cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference("game-review")
  private List<Review> reviews;

  /** Listas de juegos. */
  @OneToMany
  @JoinColumn(name = "gameslist_id")
  private List<GamesList> gamesList;

  /** Puntuaciones del juego. */
  @OneToMany
  @JoinColumn(name = "game_score_id")
  private List<GameScore> gameScores;

  /** Sagas a las que pertenece el juego. */
  @OneToMany
  @JoinColumn(name = "saga_id")
  private List<Saga> sagas;

  /** Tiene Cross play. */
  @NotNull
  @ManyToOne
  @JoinColumn(name = "crossplay_id")
  private Crossplay crossplay;

  @Serial private static final long serialVersionUID = 1L;
}
