package ifrs.com.br.aula.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MinhaException extends RuntimeException {

  MinhaException(String mensagem) {

    super(mensagem);
  }
}
