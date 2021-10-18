package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class dataNascimentoMaiorException extends Exception {
    public dataNascimentoMaiorException() {
        super("Não é possível cadastrar atores não nascidos.");
    }
}
