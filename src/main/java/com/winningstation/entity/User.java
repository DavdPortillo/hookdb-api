package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

/**
 * Clase que representa a un usuario del sistema.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

  /** Id único del cliente. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Nombre del cliente. No puede ser nulo y debe tener entre 2 y 15 caracteres. */
  @NotNull(message = "El nombre de usuario no puede estar vacío")
  @Size(min = 3, max = 15, message = "El nombre de usuario debe tener al menos 3 caracteres y solo puede contener hasta 15 caracteres")
  @Pattern(regexp = "^[a-zA-Z][a-zA-Z0-9_]*$", message = "El nombre de usuario debe comenzar con una letra y solo puede contener letras, números o guiones bajos")
  @Column(unique = true)
  private String username;

  /** Imagen del cliente. */
  private String image;

  /** alt de la imagen del cliente. */
  private String alt;

  /** Fecha cuando se registró el cliente. No puede ser nulo. */
  @CreationTimestamp private LocalDateTime registerDate;

  /** Email del cliente. No puede ser null */
  @NotNull(message = "El email no puede estar vacío")
  @Column(unique = true)
  @Email(message = "El email debe ser válido")
  private String email;

  /** Contraseña del cliente. No puede ser nulo y debe tener al menos 6 caracteres. */
  /** Contraseña del cliente. No puede ser nulo y debe tener al menos 6 caracteres. */
  @NotNull(message = "La contraseña no puede estar vacía")
  @Size(min = 6, message = "La contraseña no puede tener menos de 6 caracteres")
  @Size(max = 100, message = "La contraseña no puede tener más de 100 caracteres")
  @Pattern(regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*])[a-zA-Z0-9!@#$%^&*]{6,}$", message = "La contraseña debe contener al menos un carácter especial y al menos un número")
  private String password;

  /** Nacionalidad del cliente. */
  @Size(min = 2, max = 50)
  private String country;

  /** Género del cliente. */
  @Pattern(
      regexp = "^(masculino|male|femenino|female|otros|other)$",
      message = "El género debe ser masculino/male, femenino/female u otros/other")
  private String gender;

  /** Año de nacimiento del cliente. */
  @Min(value = 1900, message = "El año de nacimiento debe ser mayor o igual a 1900")
  @Max(value = 2099, message = "El año de nacimiento debe ser menor o igual a 2099")
  private Integer year;

  /** Idioma del cliente. */
  @Size(min = 2, max = 30)
  private String language;

  /**
   * Rol del cliente. No puede ser nulo y se carga de manera inmediata cuando se carga la entidad
   * Client.
   */
  @NotNull
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "role_id")
  private Role role;

  /** Comentarios hechos en las noticias por el usuario. */
  @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
  @JsonIgnore
  private List<NewsComment> newsComments;

  /** Puntuaciones que ha puntuado el usuario. */
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JsonManagedReference("user-score")
  private List<GameScore> gameScores;

  /** Críticas hechas por el usuario. */
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Review> reviews;

  /** Likes o dislikes que hace un usuario hecho por el usuario. */
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonManagedReference("user-review-vote")
  private List<ReviewVote> reviewVotes;

  /** Juegos que sigue el usuario. */
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  @JsonManagedReference("user-follow-game")
  private List<FollowGame> followGames;

  /** Listas de juegos que ha creado el usuario. */
  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<GamesList> gamesLists;

  @Serial private static final long serialVersionUID = 1L;
}
