package br.com.cwi.reset.edersonrafaelnonnemacher;

public class dataNascimentoMaiorDiretorException extends Exception {
    public dataNascimentoMaiorDiretorException() {
        super("Não é possível cadastrar diretores não nascidos.");
    }
}
