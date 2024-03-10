package com.winningstation.dto;

import com.winningstation.entity.User;
import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class UpdateUserRequest {
  private User updatedUser;
  @Nullable private String oldPassword;
  @Nullable private String newPassword;
}
