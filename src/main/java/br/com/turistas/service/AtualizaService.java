package br.com.turistas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.turistas.controller.form.PerfilForm;
import br.com.turistas.dto.PerfilDTO;
import br.com.turistas.repository.PerfilRepository;

@Service
public class AtualizaService {


  @Autowired
  PerfilRepository perfilRepository;


  public ResponseEntity<PerfilDTO> atualizarPerfil(String nome, PerfilForm perfil) {

    var dado = perfilRepository.findByPerfil(nome);
    if (dado.isPresent()) {
      dado.get().setPerfil(perfil.getPerfil());

      return ResponseEntity.ok(new PerfilDTO(perfil.getPerfil().trim()));
    }

    return ResponseEntity.notFound().build();
  }


}
