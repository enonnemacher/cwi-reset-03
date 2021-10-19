package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class FiltroNomeNaoEncontradoException extends Exception {

    public FiltroNomeNaoEncontradoException(String tipo, String parametro) {
        super(String.format("%s não encontrato com o filtro %s, favor informar outro filtro.", tipo, parametro));
    }
}
