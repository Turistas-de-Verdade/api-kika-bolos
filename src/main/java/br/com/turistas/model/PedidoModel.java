package br.com.turistas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDO", schema = "dbo")
public class PedidoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer codPedido;

  @Column(name = "COD_PRODUTO")
  Integer codProduto;

  @Column(name = "COD_USUARIO", nullable = false)
  Integer codUsuario;

  @Column(name = "QUANTIDADE", nullable = false)
  Integer quantidade;

  public PedidoModel() {

  }

  public PedidoModel(Integer codProduto, Integer codUsuario, Integer quantidade) {
    super();
    this.codProduto = codProduto;
    this.codUsuario = codUsuario;
    this.quantidade = quantidade;
  }

  public PedidoModel(Integer codPedido, Integer codProduto, Integer codUsuario,
      Integer quantidade) {
    super();
    this.codPedido = codPedido;
    this.codProduto = codProduto;
    this.codUsuario = codUsuario;
    this.quantidade = quantidade;
  }

  public Integer getCodPedido() {
    return codPedido;
  }

  public void setCodPedido(Integer codPedido) {
    this.codPedido = codPedido;
  }

  public Integer getCodProduto() {
    return codProduto;
  }

  public void setCodProduto(Integer codProduto) {
    this.codProduto = codProduto;
  }

  public Integer getCodUsuario() {
    return codUsuario;
  }

  public void setCodUsuario(Integer codUsuario) {
    this.codUsuario = codUsuario;
  }

  public Integer getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }


}
