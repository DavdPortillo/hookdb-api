package com.winningstation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class UserAdminDTO {

  private long id;
  private String username;
  private String email;
}
