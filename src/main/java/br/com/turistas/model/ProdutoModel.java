package br.com.turistas.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO", schema = "dbo")
public class ProdutoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer codProduto;

  @Column(name = "NOME", nullable = false)
  String nome;

  @Column(name = "PRECO", nullable = false)
  BigDecimal preco;

  public ProdutoModel(Integer codProduto, String nome, BigDecimal preco) {
    super();
    this.codProduto = codProduto;
    this.nome = nome;
    this.preco = preco;
  }

  public ProdutoModel() {

  }

  public Integer getCodProduto() {
    return codProduto;
  }

  public void setCodProduto(Integer codProduto) {
    this.codProduto = codProduto;
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


