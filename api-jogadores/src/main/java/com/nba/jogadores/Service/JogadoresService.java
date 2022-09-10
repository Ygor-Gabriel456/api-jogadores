package com.nba.jogadores.Service;

import com.nba.jogadores.DTO.JogadoresDTO;
import com.nba.jogadores.Domain.Jogadores;
import com.nba.jogadores.Repository.JogadoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static com.mysql.cj.conf.PropertyKey.logger;

@Service
public class JogadoresService {

  private Logger logger = Logger.getLogger(JogadoresService.class.getName());

  @Autowired
  private JogadoresRepository rep;

  public List<JogadoresDTO> getJogadores(){
    List<JogadoresDTO> list = rep.findAll().stream().map(JogadoresDTO::create).collect(Collectors.toList());
    return list;
  }

  public JogadoresDTO getJogadoresByNome(String nome) {
    logger.info("Finding name");
    return JogadoresDTO.create(rep.getJogadoresByNome(nome));
  }


  public JogadoresDTO getJogadoresByNumCamisa(Long numCamisa) {
    logger.info("Finding one Num");
    return JogadoresDTO.create(rep.getJogadoresByNumCamisa(numCamisa));
  }
  
  public List<JogadoresDTO> getJogadoresByTime(String time) {
    logger.info("Finding one Team");
    return rep.getJogadoresByTime(time).stream().map(JogadoresDTO::create).collect(Collectors.toList());
  }



  public JogadoresDTO atualizarJogadores(Jogadores jogadores) {
    logger.info("Update Players");
    return JogadoresDTO.create(rep.save(jogadores));
  }


  public void deleteById(Long id) {
    logger.info("Delete by Id");
    rep.deleteById(id);
  }


  public Object incluirJogadores(Jogadores jogadores) {
    logger.info("Creating Player");
    return rep.save(jogadores);
  }
}

