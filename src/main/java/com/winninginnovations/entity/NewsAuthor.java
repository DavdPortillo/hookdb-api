package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Clase que representa el autor de una noticia.
 */
@Data
@Entity
@Table(name = "news_author")
public class NewsAuthor implements Serializable {

    /**
     * ID único del autor. Generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del autor.
     */
    @NotNull
    @Size(min = 2, max = 30)
    private String name;

    /**
     * Apellido del autor.
     */
    @NotNull
    @Size(min = 2, max = 80)
    private String surname;

    /**
     * Imagen del autor.
     */
    @NotNull
    private String image;

    /**
     * Id para la serialización.
     */
    @Serial
    private static final long serialVersionUID = 1L;

}
