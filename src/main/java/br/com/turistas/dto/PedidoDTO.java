package br.com.turistas.dto;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.MappedSuperclass;
import javax.persistence.SqlResultSetMapping;

@MappedSuperclass
@SqlResultSetMapping(name = "PedidoDTOInfo",
    classes = {@ConstructorResult(targetClass = PedidoDTO.class,
        columns = {@ColumnResult(name = "CODIGO_PEDIDO", type = Integer.class),
            @ColumnResult(name = "NOME_USUARIO", type = String.class),
            @ColumnResult(name = "NOME_PRODUTO", type = String.class),
            @ColumnResult(name = "QUANTIDADE", type = Integer.class),
            @ColumnResult(name = "VALOR_TOTAL", type = Double.class)})})
public class PedidoDTO {

  Integer codPedido;
  String nomeUsuario;
  String nomeProduto;
  Integer quantidade;
  Double preco;


  public PedidoDTO(Integer codPedido, String nomeUsuario, String nomeProduto, Integer quantidade,
      Double preco) {
    super();
    this.codPedido = codPedido;
    this.nomeUsuario = nomeUsuario;
    this.nomeProduto = nomeProduto;
    this.preco = preco;
    this.quantidade = quantidade;
  }


  public Integer getCodPedido() {
    return codPedido;
  }


  public void setCodPedido(Integer codPedido) {
    this.codPedido = codPedido;
  }


  public String getNomeProduto() {
    return nomeProduto;
  }


  public String getNomeUsuario() {
    return nomeUsuario;
  }


  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }


  public void setNomeProduto(String nomeProduto) {
    this.nomeProduto = nomeProduto;
  }


  public Double getPreco() {
    return preco;
  }


  public void setPreco(Double preco) {
    this.preco = preco;
  }


  public Integer getQuantidade() {
    return quantidade;
  }


  public void setQuantidade(Integer quantidade) {
    this.quantidade = quantidade;
  }


}
