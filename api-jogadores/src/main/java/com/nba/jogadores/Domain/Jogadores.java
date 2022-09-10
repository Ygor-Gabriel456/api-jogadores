package com.nba.jogadores.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "jogadores")

public class Jogadores {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Long numCamisa;
  private String nome;
  private float altura;
  private String time;

}
