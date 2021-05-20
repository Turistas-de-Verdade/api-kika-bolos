package br.com.turistas.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import br.com.turistas.dto.DuvidaDTO;
import br.com.turistas.dto.PedidoDTO;
import br.com.turistas.dto.ProdutoDTO;
import br.com.turistas.repository.ProdutoRepository;
import br.com.turistas.service.ListaService;

@RestController
@RequestMapping("/turistas-ecom/lista")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ListaController {

  @Autowired
  ProdutoRepository produtoRepository;

  @Autowired
  ListaService listaService;


  @GetMapping("/produtos")
  public List<ProdutoDTO> getProdutos() {
    return listaService.listarProdutos();
  }


  @GetMapping("/produtos/{nomeProduto}")
  public List<ProdutoDTO> getProdutosPeloNome(@PathVariable String nomeProduto) {
    return listaService.listarProdutosPeloNome(nomeProduto);
  }

  @GetMapping("/pedidos/{codUsuario}")
  public List<PedidoDTO> getPedido(@PathVariable String codUsuario) {
    return listaService.listarPedido(codUsuario);
  }

  @GetMapping("/duvidas")
  public List<DuvidaDTO> getDuvidas(
      @RequestParam(value = "titulo", required = false, defaultValue = "") String titulo) {
    return listaService.listarDuvidas(titulo);
  }

}
