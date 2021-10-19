package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ListaVaziaException extends Exception {

    public ListaVaziaException(String tipo, String tipoPlural) {
        super(String.format("Nenhum %s cadastrado, favor cadastar %s.", tipo, tipoPlural));
    }
}
