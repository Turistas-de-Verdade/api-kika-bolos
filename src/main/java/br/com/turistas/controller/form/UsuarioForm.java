package br.com.turistas.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class UsuarioForm {
  @NotNull
  @NotEmpty
  String nome;
  @NotNull
  @NotEmpty
  @Email
  String email;
  @NotNull
  @NotEmpty
  @Length(min = 6)
  String senha;
  @NotNull
  @NotEmpty
  String tipoPerfil;

  public UsuarioForm(String nome, String email, String senha, String tipoPerfil) {
    super();
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.tipoPerfil = tipoPerfil;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSenha() {
    return senha;
  }

  public void setSenha(String senha) {
    this.senha = senha;
  }

  public String getTipoPerfil() {
    return tipoPerfil;
  }

  public void setTipoPerfil(String tipoPerfil) {
    this.tipoPerfil = tipoPerfil;
  }



}
