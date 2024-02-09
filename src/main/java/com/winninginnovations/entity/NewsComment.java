package com.winninginnovations.entity;

import java.io.Serializable;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Clase que representa a un comentario hecho por un usuario de una noticia.
 * 
 */
@Data
@Entity
@Table(name = "news_comment")
public class NewsComment implements Serializable {

	/**
	 * ID único del comentario. Generado automáticamente.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	/**
	 * Contenido del comentario. No puede ser nulo.
	 */
	@NotNull
	@Size(min = 2, max = 2000)
	private String content;

	/**
	 * Date del comentario. No puede ser nulo.
	 */
	@NotNull
	private String date;

	/**
	 * Noticia a la que pertenece el comentario. No puede ser nulo.
     */
	@NotNull
	@ManyToOne
	@JoinColumn(name = "news_id")
	private News news;

	private static final long serialVersionUID = 1L;

}
