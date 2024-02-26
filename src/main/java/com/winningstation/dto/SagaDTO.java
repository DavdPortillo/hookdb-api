package com.winningstation.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa a una saga del sistema.
 *
 * @author David Portillo Hoyos
 */
@Data
public class SagaDTO implements Serializable {
  private Long id;
  private String name;
  private List<GameDTO> games;
}
