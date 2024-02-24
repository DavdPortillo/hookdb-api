package com.winninginnovations.DTO;

import lombok.Data;

import java.util.List;

/**
 * Clase que representa a una saga del sistema.
 *
 * @author David Portillo Hoyos
 */
@Data
public class SagaDTO {
  private Long id;
  private String name;
  private List<GameDTO> games;

}
