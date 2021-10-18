package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class DiretorNaoEncontradoComFiltroException extends Exception {
    public DiretorNaoEncontradoComFiltroException(String filtroNome) {
        super("Diretor não encontrado com o filtro " + filtroNome + ", favor informar outro filtro.");
    }
}
