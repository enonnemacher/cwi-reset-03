package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CampoRepetidoException extends Exception {
    public CampoRepetidoException(String campo) {
        super(String.format("Não é permitido informar o mesmo %s mais de uma vez para o mesmo filme.", campo));
    }
}
