package com.winningstation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class DLCDto {

  private Long id;
  private String name;
  private LocalDate date;
  private String sinopsis;
  private String image;
  private String alt;
  private String gameTitle;
}
