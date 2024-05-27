package com.winningstation.dto;

import lombok.Data;

import java.time.LocalDate;

@Data

public class GameSearchDTO {
  private Long id;
  private String title;
  private String cover;
  private String alt;
  private LocalDate date;
  private String developer;
  private Double score;
  private Double price; // Nuevo campo para el precio

}
