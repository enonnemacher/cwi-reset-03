package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class atorSemSobrenomeException extends Exception {
    public atorSemSobrenomeException(String nome) {
        super("Deve ser informado no mínimo nome e sobrenome para o ator " + nome);
    }
}
