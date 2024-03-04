package com.winningstation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO para el promedio de puntuación de un juego y el número de puntuaciones.
 *
 * @author David Portillo Hoyos
 */
@Data
@AllArgsConstructor
public class ScoreAverageResultDTO implements Serializable {
  private Double averageScore;
  private Long scoreCount;
}
