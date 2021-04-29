package br.com.turistas.config.validacao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ValidacaoHandler {

  @Autowired
  MessageSource messageSource;

  @ResponseStatus(code = HttpStatus.BAD_REQUEST)
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public List<ErroDTO> handle(MethodArgumentNotValidException ex) {

    List<FieldError> fieldError = ex.getBindingResult().getFieldErrors();
    List<ErroDTO> erros = new ArrayList<ErroDTO>();

    erros.addAll(fieldError.stream().map(e -> {
      String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
      return new ErroDTO(e.getField(), mensagem);
    }).collect(Collectors.toList()));

    return erros;
  }

}
