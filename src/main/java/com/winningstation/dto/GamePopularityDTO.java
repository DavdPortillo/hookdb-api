package com.winningstation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class GamePopularityDTO implements Serializable {
  private Long getId;

  private String getTitle;

  private String getCover;

  private String getAlt;

  private Long getPopularity;

  private LocalDate getDate;
}
