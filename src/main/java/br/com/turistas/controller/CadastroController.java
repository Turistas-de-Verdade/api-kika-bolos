package br.com.turistas.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.turistas.controller.form.UsuarioForm;
import br.com.turistas.dto.UsuarioDTO;
import br.com.turistas.service.CadastroService;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/turistas-ecom/cadastrar")
public class CadastroController {



  @Autowired
  CadastroService cadastroService;

  @PostMapping("/usuario")
  @Transactional
  public ResponseEntity<UsuarioDTO> postUsuarios(@RequestBody @Valid UsuarioForm form,
      UriComponentsBuilder uriBuilder) {

    return cadastroService.cadastrarUsuario(form, uriBuilder);

  }
}
