package br.com.turistas.config.validacao;

public class ErroDTO {
  String campo;
  String mensagem;

  public ErroDTO(String campo, String mensagem) {
    super();
    this.campo = campo;
    this.mensagem = mensagem;
  }

  public String getCampo() {
    return campo;
  }

  public void setCampo(String campo) {
    this.campo = campo;
  }

  public String getMensagem() {
    return mensagem;
  }

  public void setMensagem(String mensagem) {
    this.mensagem = mensagem;
  }



}
