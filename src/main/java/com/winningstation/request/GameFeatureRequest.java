package com.winningstation.request;

import lombok.Data;

/**
 * Clase que representa la petición para guardar una característica.
 *
 * @author David Portillo Hoyos
 */
@Data
public class GameFeatureRequest {
  private Long featureId; // Id de la característica
  private Long numberPlayerId; // Id del número de jugadores, puede ser null
}
