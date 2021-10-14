package br.com.cwi.reset.edersonrafaelnonnemacher;

public class DiretorNaoEncontradoComFiltro extends Exception {
    public DiretorNaoEncontradoComFiltro(String filtroNome) {
        super("Diretor não encontrado com o filtro " + filtroNome + ", favor informar outro filtro.");
    }
}
