package com.nba.jogadores.Repository;

import com.nba.jogadores.DTO.JogadoresDTO;
import com.nba.jogadores.Domain.Jogadores;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface JogadoresRepository extends JpaRepository<Jogadores,Long> {


  Jogadores getJogadoresByNome(String nome);

  Jogadores getJogadoresByNumCamisa(Long numCamisa);

  List<Jogadores> getJogadoresByTime(String time);


}
