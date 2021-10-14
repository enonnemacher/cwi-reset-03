package br.com.cwi.reset.edersonrafaelnonnemacher;

public class AtorNaoEncontradoComFiltro extends Exception {
    public AtorNaoEncontradoComFiltro(String campo) {
        super("Ator não encontrado com o filtro " + campo + ", favor informar outro filtro.");
    }
}
