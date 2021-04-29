package br.com.turistas.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.turistas.config.security.TokenService;
import br.com.turistas.controller.form.LoginForm;
import br.com.turistas.dto.TokenDTO;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/turistas-ecom/auth")
public class AutenticacaoController {

  @Autowired
  TokenService tokenService;


  @PostMapping("")
  public ResponseEntity<TokenDTO> autenticar(@RequestBody @Valid LoginForm form) {

    return tokenService.retornarToken(form);
  }

}
