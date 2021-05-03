package br.com.turistas.controller.form;

import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class ProdutoForm {


  @NotNull
  @NotEmpty
  String nome;

  @NotNull
  @Positive
  BigDecimal preco;



  public ProdutoForm(@NotNull @NotEmpty String nome, @NotNull @Positive BigDecimal preco) {
    super();
    this.nome = nome;
    this.preco = preco;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public BigDecimal getPreco() {
    return preco;
  }

  public void setPreco(BigDecimal preco) {
    this.preco = preco;
  }


}
