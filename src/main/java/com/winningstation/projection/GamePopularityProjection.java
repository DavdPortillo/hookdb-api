package com.winningstation.projection;

import java.time.LocalDate;

public interface GamePopularityProjection {
  Long getId();

  String getTitle();

  String getCover();

  String getAlt();
  Long getPopularity();

  LocalDate getDate();
}
