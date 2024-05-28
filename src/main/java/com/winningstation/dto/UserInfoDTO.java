package com.winningstation.dto;

import com.winningstation.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class UserInfoDTO {

  private Long id;
  private String username;
  private String email;
  private String country;
  private Integer year;
  private String image;
  private String language;
  private String gender;
  private String alt;
  private LocalDateTime registerDate;
  private Role role;
}
