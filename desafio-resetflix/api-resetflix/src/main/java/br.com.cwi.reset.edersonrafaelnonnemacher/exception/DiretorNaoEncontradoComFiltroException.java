package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class DiretorNaoEncontradoComFiltroException extends Exception {
    public DiretorNaoEncontradoComFiltroException(String filtroNome) {
        super("Diretor não encontrado com o filtro " + filtroNome + ", favor informar outro filtro.");
    }
}
