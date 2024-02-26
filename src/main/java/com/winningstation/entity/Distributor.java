package com.winningstation.entity;

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
 * Clase que a los distribuidores de los juegos.
 */
@Data
@Entity
@Table(name = "distributor")
public class Distributor implements Serializable {

    /**
     * Id único del distribuidor. Generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del distribuidor.
     */
    @NotNull
    private String name;

    @Serial
    private static final long serialVersionUID = 1L;

}
