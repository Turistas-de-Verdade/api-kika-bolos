package br.com.turistas.config.security;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import br.com.turistas.controller.form.LoginForm;
import br.com.turistas.dto.TokenDTO;
import br.com.turistas.model.UsuarioModel;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

  private static final String CONST_ISSUER = "API do App Hair-Sallon";

  private static final String CONST_TIPO = "Bearer";

  @Autowired
  AuthenticationManager authManager;

  @Value("${hairsallon.jwt.secret}")
  String secret;

  public UsernamePasswordAuthenticationToken conventer(LoginForm form) {
    return new UsernamePasswordAuthenticationToken(form.getEmail(), form.getSenha());
  }

  public ResponseEntity<TokenDTO> retornarToken(LoginForm form) {

    try {
      UsernamePasswordAuthenticationToken dadosLogin = conventer(form);
      Authentication authetication = authManager.authenticate(dadosLogin);
      String token = gerarToken(authetication);

      return ResponseEntity.ok().body(new TokenDTO(token, CONST_TIPO));

    } catch (Exception e) {
      return ResponseEntity.badRequest().build();
    }

  }

  public String gerarToken(Authentication authetication) {

    UsuarioModel logado = (UsuarioModel) authetication.getPrincipal();
    Date hoje = new Date();
    GregorianCalendar gc = new GregorianCalendar();
    gc.clear();
    gc.setTime(hoje);
    gc.add(Calendar.MINUTE, 1440);

    return Jwts.builder().setIssuer(CONST_ISSUER).setSubject(logado.getCodUsuario().toString())
        .setIssuedAt(hoje).setExpiration(gc.getTime()).signWith(SignatureAlgorithm.HS256, secret)
        .compact();

  }

  public boolean verificarToken(String token) {

    try {
      Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
      return true;
    } catch (Exception e) {
      return false;
    }
  }

  public Integer getCodUsuario(String token) {

    Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();
    return Integer.parseInt(claims.getSubject());

  }

}
