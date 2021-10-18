package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class diretorSemSobrenomeException extends Exception {
    public diretorSemSobrenomeException(String nome) {
        super("Deve ser informado no mínimo nome e sobrenome para o diretor " + nome);
    }
}
