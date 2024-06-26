package com.winningstation.request;

import com.winningstation.entity.Game;
import com.winningstation.entity.Saga;
import com.winningstation.entity.SystemRequirement;
import lombok.Data;

import java.util.List;

/**
 * Clase que representa la petición para guardar un juego.
 *
 * @author David Portillo Hoyos
 */
@Data
public class GameRequest {
  private Game game;
  private List<Long> platformIds;
  private Long crossplayId;
  private List<Long> genreIds;
  private List<Long> developerIds;
  private List<Long> distributorIds;
  private List<Long> dlcIds;
  private List<AvailabilityRequest> availabilities;
  private List<GameFeatureRequest> gameFeatures;
  private Saga saga;
  private SystemRequirement minimumSystemRequirement;
  private SystemRequirement recommendedSystemRequirement;
  private List<ProductRequest> products;
}
