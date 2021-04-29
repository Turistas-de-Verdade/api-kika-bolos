package br.com.turistas.config.security;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import br.com.turistas.model.UsuarioModel;
import br.com.turistas.repository.UsuarioRepository;

public class AutenticacaoViaTokenFilter extends OncePerRequestFilter {

  private static final String CONST_TIPO = "Bearer ";
  private static final String CONST_AUTHORIZATION = "Authorization";

  private TokenService tokenService;
  private UsuarioRepository usuarioRepository;


  public AutenticacaoViaTokenFilter(TokenService tokenService,
      UsuarioRepository usuarioRepository) {
    super();
    this.tokenService = tokenService;
    this.usuarioRepository = usuarioRepository;
  }


  private void autenticarCliente(String token) {

    Integer codUsuario = tokenService.getCodUsuario(token);
    Optional<UsuarioModel> usuario = usuarioRepository.findByCodUsuario(codUsuario);

    UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
        usuario.get(), null, usuario.get().getAuthorities());

    SecurityContextHolder.getContext().setAuthentication(authentication);

  }

  private String recuperarToken(HttpServletRequest request) {
    String token = request.getHeader(CONST_AUTHORIZATION);
    if (token == null || token.isEmpty() || !(token.startsWith(CONST_TIPO))) {
      return null;
    }
    return token.substring(7, token.length());
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    String token = recuperarToken(request);
    boolean verificado = tokenService.verificarToken(token);

    if (verificado == true) {
      autenticarCliente(token);
    }

    filterChain.doFilter(request, response);
  }
}
