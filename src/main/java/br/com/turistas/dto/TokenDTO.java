package br.com.turistas.dto;

public class TokenDTO {

  String token;
  String tipo;

  public TokenDTO(String token, String tipo) {
    super();
    this.token = token;
    this.tipo = tipo;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

}
