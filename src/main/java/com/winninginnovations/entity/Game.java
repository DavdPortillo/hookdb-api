package com.winninginnovations.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa a un juego del sistema.
 * 
 */
@Data
@Entity
@Table(name = "game")
public class Game implements Serializable {

	/**
	 * ID único del juego. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del juego.
	 */
	@NotNull
	private String title;

	/**
	 * Imagen del juego.
	 */
	@NotNull
	private String cover;

	/**
	 * Año de lanzamiento del juego.
	 */
	@NotNull
	private String releaseYear;

	/**
	 * Trailer del juego.
	 */
	@NotNull
	private String trailer;

	/**
	 * sinopsis del juego.
	 */
	@NotNull
	private String sinopsis;

	/**
	 * Tiempo de juego de la historia del juego.
	 */
	@NotNull
	private Double storyTime;

	/**
	 * Tiempo de completar el juego al 100%.
	 */
	@NotNull
	private Double completeTime;

	/**
	 * Juegos que sigue el usuario.
	 */
	@OneToMany
	@JoinColumn(name = "genre_id")
	private List<Genre> genres;

	/**
	 * Desarrollador del juego.
	 */
	@ManyToOne
	@JoinColumn(name = "developer_id")
	private Developer developers;

	/**
	 * Distribuidor del juego.
	 */
	@ManyToOne
	@JoinColumn(name = "distributor_id")
	private Distributor distributors;

	/**
	 * Requisitos mínimos del sistema.
	 */
	@ManyToOne
	@JoinColumn(name = "minimum_system_requirement_id")
	private MinimumSystemRequirement minimumSystemRequirement;

	/**
	 * Requisitos recomendados del sistema.
	 */
	@ManyToOne
	@JoinColumn(name = "recommended_system_requirement_id")
	private RecommendedSystemRequirement recommendedSystemRequirement;

	/**
	 * Key del juego.
	 */
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;

	/**
	 * Plataformas en las que está disponible el juego.
	 */
	@OneToMany
	@JoinColumn(name = "platform_id")
	private List<Platform> platforms;

	/**
	 * Dlcs del juego.
	 */
	@OneToMany
	@JoinColumn(name = "dlc_id")
	private List<DLC> dlcs;

	/**
	 * Idiomas en los que está disponible el juego.
	 */
	@OneToMany
	@JoinColumn(name = "language_id")
	private List<Language> languages;

	/**
	 * Plataformas en las que está disponible el juego.
	 */
	@OneToMany
	@JoinColumn(name = "feature_id")
	private List<Feature> features;

	/**
	 * Noticias del juego.
	 */
	@OneToMany
	@JoinColumn(name = "news_id")
	private List<News> news;

	/**
	 * Criticas hechas por los usuarios.
	 */
	@OneToMany
	@JoinColumn(name = "review_id")
	private List<Review> reviews;

	/**
	 * Criticas hechas por los usuarios.
	 */
	@OneToMany
	@JoinColumn(name = "gameslist_id")
	private List<GamesList> gamesList;

	/**
	 * Puntuaciones del juego.
	 */
	@OneToMany
	@JoinColumn(name = "game_score_id")
	private List<GameScore> gameScores;

	/**
	 * Sagas a las que pertenece el juego.
	 */
	@OneToMany
	@JoinColumn(name = "saga_id")
	private List<Saga> sagas;

	/**
	 * Tiene crossplay.
	 */
	@OneToOne
	@JoinColumn(name = "crossplay_id")
	private Crossplay crossplay;

	private static final long serialVersionUID = 1L;

}
