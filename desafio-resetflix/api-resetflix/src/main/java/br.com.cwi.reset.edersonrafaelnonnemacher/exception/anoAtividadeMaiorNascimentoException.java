package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class anoAtividadeMaiorNascimentoException extends Exception {
    public anoAtividadeMaiorNascimentoException(String campo){
        super(String.format("Ano de início de atividade inválido para o ator cadastrado.", campo));
    }
}
