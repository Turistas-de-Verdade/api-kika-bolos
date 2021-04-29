package br.com.turistas.controller.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class LoginForm {

  @NotNull
  @NotEmpty
  @Email
  String email;
  @NotNull
  @NotEmpty
  String senha;

  public LoginForm(@NotNull @NotEmpty @Email String email, @NotNull @NotEmpty String senha) {
    super();
    this.email = email;
    this.senha = senha;
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


}
