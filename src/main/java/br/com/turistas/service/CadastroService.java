package br.com.turistas.service;

import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.turistas.controller.form.PerfilForm;
import br.com.turistas.controller.form.UsuarioForm;
import br.com.turistas.dto.UsuarioDTO;
import br.com.turistas.model.PerfilModel;
import br.com.turistas.model.UsuarioModel;
import br.com.turistas.repository.PerfilRepository;
import br.com.turistas.repository.UsuarioRepository;
import br.com.turistas.service.helper.ServiceHelper;

@Service
public class CadastroService {

  @Autowired
  PerfilRepository perfilRepository;

  @Autowired
  UsuarioRepository usuarioRepository;


  public ResponseEntity<PerfilForm> cadastrarPerfil(@Valid PerfilForm perfil,
      UriComponentsBuilder uriBuilder) {

    perfilRepository.save(new PerfilModel(perfil.getPerfil()));

    URI uri = uriBuilder.path("/hair-sallon/lista/servicos?nomePerfil=")
        .buildAndExpand(perfil.getPerfil()).toUri();

    return ResponseEntity.created(uri).body(new PerfilForm(perfil.getPerfil()));

  }

  public ResponseEntity<UsuarioDTO> cadastrarUsuario(@Valid UsuarioForm form,
      UriComponentsBuilder uriBuilder) {

    Integer codPerfilValidado = ServiceHelper.validaPerfil(form.getTipoPerfil().trim());

    UsuarioModel entidade = new UsuarioModel(form.getNome().trim(), form.getEmail().trim(),
        ServiceHelper.encodePass(form.getSenha()), codPerfilValidado);

    usuarioRepository.save(entidade);

    URI uri = uriBuilder.path("/hair-sallon/lista/usuarios?nomeUsuario=")
        .buildAndExpand(form.getNome()).toUri();

    return ResponseEntity.created(uri).body(new UsuarioDTO(form.getNome().trim()));

  }

}


