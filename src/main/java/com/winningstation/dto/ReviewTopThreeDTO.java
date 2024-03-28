package com.winningstation.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReviewTopThreeDTO implements Serializable {

    private String authorName;
    private String reviewTitle;
    private String reviewContent;
    private Integer reviewLikes;
    private LocalDateTime reviewDate;
}
