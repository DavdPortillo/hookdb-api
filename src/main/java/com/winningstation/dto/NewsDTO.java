package com.winningstation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class NewsDTO implements Serializable {
  private Long id;
  private String image;
  private String alt;
  private String headline;
  private String authorName;
  private String authorSurname;
  private Integer commentCount;
  private LocalDateTime date;
}
