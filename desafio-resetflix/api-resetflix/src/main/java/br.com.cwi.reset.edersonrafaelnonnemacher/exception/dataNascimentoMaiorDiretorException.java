package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class dataNascimentoMaiorDiretorException extends Exception {
    public dataNascimentoMaiorDiretorException() {
        super("Não é possível cadastrar diretores não nascidos.");
    }
}
