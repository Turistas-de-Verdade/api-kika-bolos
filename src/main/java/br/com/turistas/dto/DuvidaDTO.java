package br.com.turistas.dto;

public class DuvidaDTO {


  String nomeUsuario;
  String titulo;
  String descricao;


  public DuvidaDTO() {

  }

  public DuvidaDTO(String nomeUsuario, String titulo, String descricao) {
    super();
    this.nomeUsuario = nomeUsuario;
    this.titulo = titulo;
    this.descricao = descricao;
  }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }


  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }


}
