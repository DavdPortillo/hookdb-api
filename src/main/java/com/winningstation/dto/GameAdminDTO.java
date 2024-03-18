package com.winningstation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class GameAdminDTO implements Serializable {

    private Long id;
    private String title;
    private LocalDate date;

}
