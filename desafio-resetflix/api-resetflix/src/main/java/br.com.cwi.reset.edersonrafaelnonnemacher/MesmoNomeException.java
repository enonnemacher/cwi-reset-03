package br.com.cwi.reset.edersonrafaelnonnemacher;

public class MesmoNomeException extends Exception {
    public MesmoNomeException(String nome) {
        super("Já existe um ator cadastrado para o nome %s " + nome);
    }
}
