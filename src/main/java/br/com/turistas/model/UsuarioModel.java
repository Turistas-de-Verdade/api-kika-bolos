package br.com.turistas.model;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "Usuario", schema = "dbo")
public class UsuarioModel implements UserDetails {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer codUsuario;

  @Column(name = "NOME", nullable = false)
  String nome;

  @Column(name = "EMAIL", nullable = false)
  String email;

  @Column(name = "SENHA", nullable = false)
  String senha;

  @Column(name = "COD_PERFIL", nullable = false)
  Integer codPerfil;


  public UsuarioModel() {
    super();
  }


  public UsuarioModel(String nome, String email, String senha, Integer codPerfil) {
    super();
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.codPerfil = codPerfil;
  }


  public UsuarioModel(Integer codUsuario, String nome, String email, String senha,
      Integer codPerfil) {
    super();
    this.codUsuario = codUsuario;
    this.nome = nome;
    this.email = email;
    this.senha = senha;
    this.codPerfil = codPerfil;
  }



  public Integer getCodUsuario() {
    return codUsuario;
  }


  public void setCodUsuario(Integer codUsuario) {
    this.codUsuario = codUsuario;
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


  public Integer getCodPerfil() {
    return codPerfil;
  }


  public void setCodPerfil(Integer codPerfil) {
    this.codPerfil = codPerfil;
  }


  public static long getSerialversionuid() {
    return serialVersionUID;
  }


  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return new ArrayList<PerfilModel>();
  }

  @Override
  public String getPassword() {
    return this.senha;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }


}
