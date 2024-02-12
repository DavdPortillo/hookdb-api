package com.winninginnovations.request;

import com.winninginnovations.entity.Game;
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
    private List<Long> platformsIds;
}

