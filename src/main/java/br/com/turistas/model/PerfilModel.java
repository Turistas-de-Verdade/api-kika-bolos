package br.com.turistas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "Perfil", schema = "dbo")
public class PerfilModel implements GrantedAuthority {


  /**
   * 
   */
  private static final long serialVersionUID = 1L;



  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer codPerfil;

  @Column(name = "PERFIL", nullable = false)
  String perfil;

  public PerfilModel() {

  }

  public PerfilModel(String perfil) {
    super();
    this.perfil = perfil;
  }

  public PerfilModel(Integer codPerfil, String perfil) {
    super();
    this.codPerfil = codPerfil;
    this.perfil = perfil;
  }


  public Integer getCodPerfil() {
    return codPerfil;
  }

  public void setCodPerfil(Integer codPerfil) {
    this.codPerfil = codPerfil;
  }

  public String getPerfil() {
    return perfil;
  }

  public void setPerfil(String perfil) {
    this.perfil = perfil;
  }


  @Override
  public String getAuthority() {
    return this.getPerfil();
  }



}
