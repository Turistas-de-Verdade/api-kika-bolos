package br.com.turistas.service;

import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.turistas.controller.form.DuvidaForm;
import br.com.turistas.controller.form.PedidoForm;
import br.com.turistas.controller.form.PerfilForm;
import br.com.turistas.controller.form.ProdutoForm;
import br.com.turistas.controller.form.UsuarioForm;
import br.com.turistas.dto.DuvidaDTO;
import br.com.turistas.dto.PedidoDTO;
import br.com.turistas.dto.ProdutoDTO;
import br.com.turistas.dto.UsuarioDTO;
import br.com.turistas.model.DuvidaModel;
import br.com.turistas.model.PedidoModel;
import br.com.turistas.model.PerfilModel;
import br.com.turistas.model.ProdutoModel;
import br.com.turistas.model.UsuarioModel;
import br.com.turistas.repository.DuvidaRepository;
import br.com.turistas.repository.PedidoRepository;
import br.com.turistas.repository.PedidosDTORepository;
import br.com.turistas.repository.PerfilRepository;
import br.com.turistas.repository.ProdutoRepository;
import br.com.turistas.repository.UsuarioRepository;
import br.com.turistas.service.helper.ServiceHelper;

@Service
public class CadastroService {

  @Autowired
  PerfilRepository perfilRepository;

  @Autowired
  UsuarioRepository usuarioRepository;

  @Autowired
  ProdutoRepository produtoRepository;

  @Autowired
  PedidoRepository pedidoRepository;

  @Autowired
  DuvidaRepository duvidaRepository;

  @Autowired
  PedidosDTORepository pedidosDTORepository;

  public ResponseEntity<PerfilForm> cadastrarPerfil(@Valid PerfilForm perfil,
      UriComponentsBuilder uriBuilder) {

    perfilRepository.save(new PerfilModel(perfil.getPerfil()));

    URI uri = uriBuilder.path("/turistas-ecom/lista/perfis?nomePerfil=")
        .buildAndExpand(perfil.getPerfil()).toUri();

    return ResponseEntity.created(uri).body(new PerfilForm(perfil.getPerfil()));

  }

  public ResponseEntity<UsuarioDTO> cadastrarUsuario(@Valid UsuarioForm form,
      UriComponentsBuilder uriBuilder) {

    Integer codPerfilValidado = ServiceHelper.validaPerfil(form.getTipoPerfil().trim());

    UsuarioModel entidade = new UsuarioModel(form.getNome().trim(), form.getEmail().trim(),
        ServiceHelper.encodePass(form.getSenha()), codPerfilValidado);

    usuarioRepository.save(entidade);

    URI uri = uriBuilder.path("/turistas-ecom/lista/usuarios?nomeUsuario=")
        .buildAndExpand(form.getNome()).toUri();

    return ResponseEntity.created(uri).body(new UsuarioDTO(form.getNome().trim()));

  }

  public ResponseEntity<ProdutoDTO> cadastrarProduto(@Valid ProdutoForm form,
      UriComponentsBuilder uriBuilder) {

    ProdutoModel entidade = new ProdutoModel(form.getNome(), form.getPreco());

    produtoRepository.save(entidade);

    URI uri = uriBuilder.path("/turistas-ecom/lista/produtos?nomeProduto=")
        .buildAndExpand(form.getNome()).toUri();

    return ResponseEntity.created(uri).body(new ProdutoDTO(form.getNome(), form.getPreco()));
  }


  public ResponseEntity<PedidoDTO> cadastrarPedido(@Valid PedidoForm form,
      UriComponentsBuilder uriBuilder) {

    PedidoModel entidade = new PedidoModel();
    var produto = produtoRepository.findByNome(form.getNomeProduto());

    if (produto.isPresent()) {
      entidade = new PedidoModel(produto.get().getCodProduto(), form.getCodUsuario(),
          form.getQuantidade());

      pedidoRepository.save(entidade);


      var pedidos = pedidosDTORepository.getPedidos(form.getCodUsuario());

      Integer codPedido = null;
      String nomeUsuario = null;
      Double valorTotal = null;
      if (!(pedidos.isEmpty())) {
        nomeUsuario = pedidos.stream().map(e -> e.getNomeUsuario()).findFirst().get();
        codPedido = pedidos.stream().map(e -> e.getCodPedido()).findFirst().get();
        valorTotal = pedidos.stream().map(e -> e.getPreco()).findFirst().get();
      }

      URI uri = uriBuilder.path("/turistas-ecom/lista/pedidos/").buildAndExpand(codPedido).toUri();

      return ResponseEntity.created(uri).body(new PedidoDTO(codPedido, nomeUsuario,
          form.getNomeProduto(), form.getQuantidade(), valorTotal));

    }

    return ResponseEntity.badRequest().build();
  }


  public ResponseEntity<DuvidaDTO> cadastarDuvida(@Valid DuvidaForm form,
      UriComponentsBuilder uriBuilder) {


    DuvidaModel entidade = new DuvidaModel(form.getNomeUsuario(), form.getEmail(),
        form.getDescricao(), form.getTitulo());

    duvidaRepository.save(entidade);
    URI uri = uriBuilder.path("/turistas-ecom/lista/duvidas?titulo=")
        .buildAndExpand(form.getTitulo()).toUri();

    return ResponseEntity.created(uri)
        .body(new DuvidaDTO(form.getNomeUsuario(), form.getTitulo(), form.getDescricao()));

  }



}


