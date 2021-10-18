package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class AtorNaoEncontradoComFiltroException extends Exception {
    public AtorNaoEncontradoComFiltroException(String campo) {
        super("Ator não encontrado com o filtro " + campo + ", favor informar outro filtro.");
    }
}
