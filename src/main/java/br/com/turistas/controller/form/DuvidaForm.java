package br.com.turistas.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class DuvidaForm {

  @NotNull
  @NotBlank
  String nomeUsuario;
  @NotNull
  @NotBlank
  String email;
  @NotNull
  @NotBlank
  String titulo;
  @NotNull
  @NotBlank
  String descricao;


  public DuvidaForm() {
    super();
  }

  public DuvidaForm(@NotNull @NotBlank String nomeUsuario, @NotNull @NotBlank String email,
      @NotNull @NotBlank String titulo, @NotNull @NotBlank String descricao) {
    super();
    this.nomeUsuario = nomeUsuario;
    this.email = email;
    this.titulo = titulo;
    this.descricao = descricao;
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
