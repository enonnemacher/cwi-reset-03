package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class idAtorException extends Exception {
    public idAtorException(Integer id) {
        super("Nenhum ator encontrado com o parâmetro id = " + id +", favor verifique os parâmetros informados.");
    }
}
