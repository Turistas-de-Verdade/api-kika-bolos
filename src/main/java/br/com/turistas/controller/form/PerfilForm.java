package br.com.turistas.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class PerfilForm {

  @NotNull
  @NotEmpty
  String perfil;

  public PerfilForm(String perfil) {
    super();
    this.perfil = perfil;
  }

  public PerfilForm() {

  }

  public String getPerfil() {
    return perfil;
  }

  public void setPerfil(String perfil) {
    this.perfil = perfil;
  }



}
