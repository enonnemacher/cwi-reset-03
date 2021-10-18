package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class ListaAtoresVazioException extends Exception {
    public ListaAtoresVazioException() {
        super("Nenhum ator cadastrado, favor cadastrar atores.");
    }
}
