package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class dataNascimentoMaiorException extends Exception {

    public dataNascimentoMaiorException(String campo) {
        super(String.format("Não é possível cadastrar %s não nascidos.", campo));
    }
}
