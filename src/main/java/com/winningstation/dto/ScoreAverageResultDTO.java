package com.winningstation.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO para el promedio de puntuación de un juego y el número de puntuaciones.
 *
 * @author David Portillo Hoyos
 */
@Data
public class ScoreAverageResultDTO implements Serializable {
  private Double averageScore;
  private Integer scoreCount;
}
