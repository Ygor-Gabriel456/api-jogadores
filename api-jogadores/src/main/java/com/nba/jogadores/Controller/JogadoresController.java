package com.nba.jogadores.Controller;

import com.nba.jogadores.DTO.JogadoresDTO;
import com.nba.jogadores.Domain.Jogadores;
import com.nba.jogadores.Repository.JogadoresRepository;
import com.nba.jogadores.Service.JogadoresService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Properties;

@RestController
@RequestMapping("/api/v1/jogadores")
public class JogadoresController {

  @Autowired
  private JogadoresService service;

  @GetMapping()
  public ResponseEntity get() {
    List<JogadoresDTO> jogadores = service.getJogadores();
    return ResponseEntity.ok(jogadores);
  }

  /*@GetMapping("/caminho de acesso do método/{caminho}")

    Modificador de acesso  ResponseEntity  método do Get(@PathVariable("caminho") String caminho){
    CarroDTO tabela = service.getTabelaByCaminho(caminho);
    return tabela == null ?
      ResponseEntity.noContent( ).build( ):
      ResponseEntity.ok(tabela);

  }*/

  /*@GetMapping("id/{idjogadores")
  public ResponseEntity getJogadoresById(@PathVariable ("id") Long idjogadores) {
    JogadoresDTO

  }*/

  @GetMapping("/nome/{nome}")
  public ResponseEntity getJogadoresByNome(@PathVariable("nome") String nome) {
    JogadoresDTO jogadores = service.getJogadoresByNome(nome);
    return jogadores == null ?
      ResponseEntity.noContent().build() :
      ResponseEntity.ok(jogadores);
  }

  @GetMapping("/camisa/{numCamisa}")
  public ResponseEntity getJogadoresByCamisa(@PathVariable("numCamisa") Long numCamisa) {
    JogadoresDTO jogadores = service.getJogadoresByNumCamisa(numCamisa);
       return jogadores == null ?
      ResponseEntity.noContent().build() :
      ResponseEntity.ok(jogadores);
  }

  @GetMapping("/time/{time}")
  public ResponseEntity getJogadoresByTime(@PathVariable("time") String time) {
    List<JogadoresDTO> jogadores = service.getJogadoresByTime(time);
      return jogadores.isEmpty() ?
    ResponseEntity.noContent().build() :
    ResponseEntity.ok(jogadores);
  }

  @PostMapping("/incluir")
  public ResponseEntity incluirJogadores(@RequestBody Jogadores jogadores) {
    return ResponseEntity.ok(service.incluirJogadores(jogadores));
  }

  @PutMapping("/atualizar")
  public ResponseEntity atualizarJogadores(@RequestBody Jogadores jogadores) {
    return ResponseEntity.ok(service.atualizarJogadores(jogadores));
  }

  @DeleteMapping("/delete/{id}")
  public String deleteById(@PathVariable("id") Long id) {
    service.deleteById(id);
    return "Carro" +  id  + "deletado com sucesso";
  }

}


