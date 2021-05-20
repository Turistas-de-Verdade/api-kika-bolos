package br.com.turistas.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PedidoForm {

  @NotNull
  @Positive
  Integer codUsuario;

  @NotNull
  @NotBlank
  String nomeProduto;

  @NotNull
  Integer quantidade;

  public PedidoForm(@NotNull @Positive Integer codUsuario, @NotNull @NotBlank String nomeProduto,
      @NotNull Integer quantidade) {
    super();
    this.codUsuario = codUsuario;
    this.nomeProduto = nomeProduto;
    this.quantidade = quantidade;
  }

  public Integer getCodUsuario() {
    return codUsuario;
  }

  public void setCodUsuario(Integer codUsuario) {
    this.codUsuario = codUsuario;
  }

  public String getNomeProduto() {
    return nomeProduto;
  }

  public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }

}
