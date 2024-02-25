package com.winninginnovations.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * Clase que representa a un juego del sistema quu usará saga
 *
 * @author David Portillo Hoyos
 */
@Data
public class GameDTO implements Serializable {
  private Long id;
  private String title;
  private String date;
}
