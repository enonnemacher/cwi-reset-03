package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MesmoNomeException extends Exception {
    public MesmoNomeException(String campo, String nome) {
        super(String.format("Já existe um %s cadastrado para o nome {%s}", campo, nome));
    }
}
