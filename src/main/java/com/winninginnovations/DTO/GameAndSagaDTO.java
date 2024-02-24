package com.winninginnovations.DTO;

import com.winninginnovations.entity.Game;
import lombok.Data;

/**
 * Clase que representa a un juego del sistema que usará saga
 *
 * @author David Portillo Hoyos
 */
@Data
public class GameAndSagaDTO {
  private Game game;
  private SagaDTO saga;
}
