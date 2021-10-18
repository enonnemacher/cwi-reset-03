package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class ListaDiretoresVazioException extends Exception {
    public ListaDiretoresVazioException() {
        super("Nenhum diretor cadastrado, favor cadastrar diretores.");
    }
}
