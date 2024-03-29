package com.winningstation.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewTopThreeDTO implements Serializable {

    private Long id;
    private String authorName;
    private String gameTitle;
    private String reviewTitle;
    private String reviewContent;
    private Integer reviewLikes;
    private LocalDateTime reviewDate;
}
