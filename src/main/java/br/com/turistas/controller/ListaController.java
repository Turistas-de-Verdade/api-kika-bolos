package br.com.turistas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.turistas.model.ProdutoModel;
import br.com.turistas.repository.ProdutoRepository;

@RestController
@RequestMapping("/turistas-ecom/lista")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ListaController {

  @Autowired
  ProdutoRepository produtoRepository;

  @GetMapping("/produtos")
  public List<ProdutoModel> getProdutos() {
    return produtoRepository.findAll();
  }

}
