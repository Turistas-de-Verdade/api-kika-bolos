package br.com.turistas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DUVIDA", schema = "dbo")
public class DuvidaModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer codDuvida;

  @Column(name = "NOME_USUARIO", nullable = false)
  String nomeUsuario;

  @Column(name = "EMAIL", nullable = false)
  String email;

  @Column(name = "DESCRICAO", nullable = false)
  String descricao;

  @Column(name = "TITULO", nullable = false)
  String titulo;


  public DuvidaModel() {}

  public DuvidaModel(String nomeUsuario, String email, String descricao, String titulo) {
    super();
    this.nomeUsuario = nomeUsuario;
    this.email = email;
    this.descricao = descricao;
    this.titulo = titulo;
  }

  public DuvidaModel(Integer codDuvida, String nomeUsuario, String email, String descricao,
      String titulo) {
    super();
    this.codDuvida = codDuvida;
    this.nomeUsuario = nomeUsuario;
    this.email = email;
    this.descricao = descricao;
    this.titulo = titulo;
  }

  public Integer getCodDuvida() {
    return codDuvida;
  }

  public void setCodDuvida(Integer codDuvida) {
    this.codDuvida = codDuvida;
  }

  public String getNomeUsuario() {
    return nomeUsuario;
  }

  public void setNomeUsuario(String nomeUsuario) {
    this.nomeUsuario = nomeUsuario;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }



}
