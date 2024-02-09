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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa una noticia.
 * 
 */
@Data
@Entity
@Table(name = "news")
public class News implements Serializable {

	/**
	 * ID para la serialización.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ID único de la noticia. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Fecha de la noticia.
	 */
	@NotNull
	private String date;

	/**
	 * Título de la noticia.
	 */
	@NotNull
	private String headline;

	/**
	 * Imagen de la noticia.
	 */
	@NotNull
	private String image;

	/**
	 * Contenido de la noticia.
	 */
	@NotNull
	private String content;

	@NotNull
	@OneToMany
	@JoinColumn(name = "news_comment_id")
	private List<NewsComment> newsComment;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "news_author_id")
	private NewsAuthor newsAuthor;

}
