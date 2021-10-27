package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AtorVinculadoPersonagemException extends Exception {

    public AtorVinculadoPersonagemException(String campo){
        super(String.format("Este %s está vinculado a um ou mais personagens, para remover o %s é necessário" +
                "remover os seus personagens de atuação.", campo));
    }
}
