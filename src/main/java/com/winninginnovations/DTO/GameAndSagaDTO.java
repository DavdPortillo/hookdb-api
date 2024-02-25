package com.winninginnovations.DTO;

import com.winninginnovations.entity.Game;
import lombok.Data;

import java.io.Serializable;

/**
 * Clase que representa a un juego del sistema que usará saga
 *
 * @author David Portillo Hoyos
 */
@Data
public class GameAndSagaDTO implements Serializable {
  private Game game;
  private SagaDTO saga;
}
