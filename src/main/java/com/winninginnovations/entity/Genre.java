package com.winninginnovations.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa a un género de juego del sistema.
 */
@Data
@Entity
@Table(name = "genre")
public class Genre implements Serializable {

    /**
     * Id único del género de juego. Generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del género de juego.
     */
    @NotNull
    private String name;

    @Serial
    private static final long serialVersionUID = 1L;

}
