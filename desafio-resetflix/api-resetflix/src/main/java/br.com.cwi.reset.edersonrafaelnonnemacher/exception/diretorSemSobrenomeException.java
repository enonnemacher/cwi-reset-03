package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class diretorSemSobrenomeException extends Exception {
    public diretorSemSobrenomeException(String nome) {
        super("Deve ser informado no mínimo nome e sobrenome para o diretor " + nome);
    }
}
