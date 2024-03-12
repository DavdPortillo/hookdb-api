package com.winningstation.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "translation")
public class Translation implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull private String language;

  @OneToMany(cascade = CascadeType.ALL)
  @JsonIgnore
  private List<News> news;

  @OneToMany(cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Game> games;

  @Serial private static final long serialVersionUID = 1L;
}
