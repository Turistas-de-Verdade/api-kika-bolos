package br.com.turistas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import br.com.turistas.repository.ProdutoRepository;

@Service
public class DeleteService {


  @Autowired
  ProdutoRepository produtoRepository;


  public ResponseEntity<?> deletarProduto(String nomeProduto) {

    var produto = produtoRepository.findByNome(nomeProduto);
    if (produto.isPresent()) {
      produtoRepository.deleteByNome(nomeProduto);
      return ResponseEntity.ok().build();
    }

    return ResponseEntity.badRequest().build();
  }


}
