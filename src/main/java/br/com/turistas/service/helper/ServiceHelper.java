package br.com.turistas.service.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ServiceHelper {

  private static final String CONST_CLIENTE = "cliente";
  private static final String CONST_DATA_HORA = "yyyy-MM-dd HH:mm";


  public static String encodePass(String pass) {
    return new BCryptPasswordEncoder().encode(pass);
  }


  public static Integer validaPerfil(String tipoPerfil) {
    Integer codPerfil = null;
    if (CONST_CLIENTE.equalsIgnoreCase(tipoPerfil)) {
      codPerfil = 1;
    } else {
      codPerfil = 2;
    }
    return codPerfil;
  }


  public static String formataDataHora(String dataHora) {

    if (dataHora == null || dataHora.isBlank()) {
      return null;
    }

    SimpleDateFormat sdfDataHora = new SimpleDateFormat(CONST_DATA_HORA);
    GregorianCalendar gcDataHora = new GregorianCalendar();
    gcDataHora.setTime(new Date());

    try {
      gcDataHora.setTime(sdfDataHora.parse(dataHora));
    } catch (ParseException e) {
      e.getMessage();
    }
    String horarioFormatado = sdfDataHora.format(gcDataHora.getTime());
    return horarioFormatado;
  }


}
