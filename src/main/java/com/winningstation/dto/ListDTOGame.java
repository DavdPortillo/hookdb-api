package com.winningstation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ListDTOGame implements Serializable {

  private Long id;
  private String name;
  private LocalDateTime date;
  private Boolean isThisGameInList;
}
