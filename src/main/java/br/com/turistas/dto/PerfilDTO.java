package br.com.turistas.dto;

public class PerfilDTO {

  String descricao;

  public PerfilDTO(String descricao) {
    super();
    this.descricao = descricao;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }


}
