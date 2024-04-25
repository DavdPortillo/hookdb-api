package com.winningstation.dto;

import com.winningstation.entity.GameScore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class GameScoreGamesDTO {
  private Long id;
  private String name;
  private String image;
  private String alt;
  private LocalDate date;
  private GameScore gameScore;
}
