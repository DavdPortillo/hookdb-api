package com.winninginnovations.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Clase que representa a un usuario del sistema.
 * 
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

	/**
	 * ID único del cliente. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Nombre del cliente. No puede ser nulo y debe tener entre 2 y 50 caracteres.
	 */
	@NotNull
	@Size(min = 2, max = 50)
	private String name;

	/**
	 * Imagen del cliente.
	 */
	private String image;

	/**
	 * Fecha cuando se registro el cliente. No puede ser nulo.
	 */
	@NotNull
	private String date;

	/**
	 * Email del cliente. No puede ser null
	 */
	@NotNull
	@Column(unique = true)
	@Email
	private String email;

	/**
	 * Contraseña del cliente. No puede ser nulo y debe tener al menos 6 caracteres.
	 */
	@NotNull
	@Size(min = 6, max = 14)
	private String password;

	/**
	 * Nacionalidad del cliente.
	 */
	@Size(min = 2, max = 50)
	private String country;

	/**
	 * Género del cliente.
	 */
	@Pattern(regexp = "^(masculino|male|femenino|female|otros|other)$", message = "El género debe ser masculino/male, femenino/female u otros/other")
	private String genero;

	/**
	 * Año de nacimiento del cliente.
	 */
	@Min(value = 1900, message = "El año de nacimiento debe ser mayor o igual a 1900")
	@Max(value = 2099, message = "El año de nacimiento debe ser menor o igual a 2099")
	private Integer year;

	/**
	 * Idioma del cliente.
	 */
	@Size(min = 2, max = 30)
	private String language;

	/**
	 * Teléfono del cliente.
	 */
	@Size(min = 6, max = 20)
	private String phone;

	/**
	 * Rol del cliente. No puede ser nulo y se carga de manera inmediata cuando se
	 * carga la entidad Client.
	 */
	@NotNull
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;

	/**
	 * Comentarios hechos en las noticias por el usuario.
	 */
	@OneToMany
	@JoinColumn(name = "news_comment_id")
	private List<NewsComment> newsComments;

	/**
	 * Puntuaciones que ha puntuado el usuario.
	 */
	@OneToMany
	@JoinColumn(name = "game_score_id")
	private List<GameScore> gameScores;

	/**
	 * Criticas hechas por el usuario.
	 */
	@OneToMany
	@JoinColumn(name = "review_id")
	private List<Review> reviews;

	/**
	 * Likes o dislikes que hace un usuario hechos por el usuario.
	 */
	@OneToMany
	@JoinColumn(name = "review_vote_id")
	private List<ReviewVote> reviewVotes;

	/**
	 * Juegos que sigue el usuario.
	 */
	@OneToMany
	@JoinColumn(name = "follow_game_id")
	private List<FollowGame> followGames;

	/**
	 * Listas de juegos que ha creado el usuario.
	 */
	@OneToMany
	@JoinColumn(name = "gameslist_id")
	private List<GamesList> gamesLists;

	private static final long serialVersionUID = 1L;

}
