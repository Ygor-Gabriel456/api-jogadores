package com.nba.jogadores.DTO;

import com.nba.jogadores.Domain.Jogadores;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class JogadoresDTO {
  private Long id;
  private Long numCamisa;
  private String nome;
  private float altura;
  private String time;

  public static JogadoresDTO create(Jogadores jogadores){
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(jogadores, JogadoresDTO.class);
  }

}

