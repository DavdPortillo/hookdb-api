package com.winningstation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class GameSearchAdminDTO {

  private Long id;
  private String title;
  private LocalDate date;
  private String language;
}
