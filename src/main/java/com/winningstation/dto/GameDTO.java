package com.winningstation.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Clase que representa a un juego del sistema quu usará saga
 *
 * @author David Portillo Hoyos
 */
@Data
public class GameDTO implements Serializable {
  private Long id;
  private String title;
  private LocalDate date;

}
