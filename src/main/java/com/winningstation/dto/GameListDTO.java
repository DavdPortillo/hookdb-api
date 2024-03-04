package com.winningstation.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GameListDTO implements Serializable {

  private Long id;
  private String name;
  private String image;
  private int year;
  private ScoreAverageResultDTO rate;
  private List<String> genres;
  private List<String> platforms;
}
