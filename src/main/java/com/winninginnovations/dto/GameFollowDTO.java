package com.winninginnovations.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Clase que representa el seguimiento de un juego por parte de un usuario.
 *
 * @author David Portillo Hoyos
 */
@Data
public class GameFollowDTO implements Serializable {

  private Long id;
  private String title;
  private List<Long> newsIds;
}
