package br.com.turistas.dto;

public class UsuarioDTO {

  String nome;


  public UsuarioDTO(String nome) {
    super();
    this.nome = nome;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

}
