package com.winninginnovations.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.ToString;

/**
 * Clase que representa una noticia.
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
    @Column(columnDefinition = "TEXT")
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
    @Column(columnDefinition = "TEXT")
    private String content;

    /**
     * Comentarios de la noticia.
     */
    @OneToMany(mappedBy = "news")
    private List<NewsComment> newsComment;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "news_author_id")
    private NewsAuthor newsAuthor;

    /**
     * Noticias del juego.
     */
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Game game;

}
