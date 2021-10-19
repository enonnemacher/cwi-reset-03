package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ConsultaIdInvalidoException extends Exception {

    public ConsultaIdInvalidoException(String tipo, Integer id) {
        super(String.format("Nenhum %s encontrado com o parâmetro id = %d, favor verifique os parâmetros informados.", tipo, id));
    }
}
