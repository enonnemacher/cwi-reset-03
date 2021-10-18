package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class MesmoNomeException extends Exception {
    public MesmoNomeException(String nome) {
        super("Já existe um ator cadastrado para o nome " + nome);
    }
}
