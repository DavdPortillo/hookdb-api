package com.winningstation.entity;

import java.io.Serial;
import java.io.Serializable;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 * Clase que representa los requisitos de sistema de un juego.
 *
 * @author David Portillo Hoyos
 */
@Data
@Entity
@Table(name = "system_requirement")
public class SystemRequirement implements Serializable {

  /** ID único de los requisitos de sistema. Generado automáticamente. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /** Sistema operativo. */
  @NotNull private String operatingSystem;

  /** Procesador. */
  @NotNull private String processor;

  /** Memoria RAM. */
  @NotNull private String ram;

  /** Tarjeta gráfica. */
  @NotNull private String graphicsCard;

  /** Versión de DirectX. */
  @NotNull private String directX;

  /** Almacenamiento. */
  @NotNull private String storage;

  @Serial private static final long serialVersionUID = 1L;
}
