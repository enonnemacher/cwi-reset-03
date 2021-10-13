package br.com.cwi.reset.edersonrafaelnonnemacher;

public class anoAtividadeMaiorNascimentoException extends Exception {
    public anoAtividadeMaiorNascimentoException(){
        super("Ano de início de atividade inválido para o ator cadastrado.");
    }
}
