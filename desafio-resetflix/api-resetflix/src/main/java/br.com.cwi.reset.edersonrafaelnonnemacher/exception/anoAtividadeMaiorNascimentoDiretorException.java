package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class anoAtividadeMaiorNascimentoDiretorException extends Exception {
    public anoAtividadeMaiorNascimentoDiretorException(){
        super("Ano de início de atividade inválido para o diretor cadastrado.");
    }
}