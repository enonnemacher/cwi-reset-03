package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MesmoNomeException extends Exception {
    public MesmoNomeException(String nome) {
        super("Já existe um ator cadastrado para o nome " + nome);
    }
}
