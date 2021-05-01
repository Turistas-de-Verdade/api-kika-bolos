package br.com.turistas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.turistas.controller.form.PerfilForm;
import br.com.turistas.controller.form.ProdutoForm;
import br.com.turistas.dto.PerfilDTO;
import br.com.turistas.dto.ProdutoDTO;
import br.com.turistas.repository.PerfilRepository;
import br.com.turistas.repository.ProdutoRepository;

@Service
public class AtualizaService {


  @Autowired
  PerfilRepository perfilRepository;

  @Autowired
  ProdutoRepository produtoRepository;

  public ResponseEntity<PerfilDTO> atualizarPerfil(String nome, PerfilForm perfil) {

    var dado = perfilRepository.findByPerfil(nome);
    if (dado.isPresent()) {
      dado.get().setPerfil(perfil.getPerfil());

      return ResponseEntity.ok(new PerfilDTO(perfil.getPerfil().trim()));
    }

    return ResponseEntity.notFound().build();
  }


  public ResponseEntity<ProdutoDTO> atualizarProduto(String nomeProduto, ProdutoForm form) {
    var produto = produtoRepository.findByNome(nomeProduto);

    if (produto.isPresent()) {
      produto.get().setNome(form.getNome());
      produto.get().setPreco(form.getPreco());

      return ResponseEntity.ok(new ProdutoDTO(form.getNome(), form.getPreco()));
    }

    return ResponseEntity.notFound().build();
  }

}
