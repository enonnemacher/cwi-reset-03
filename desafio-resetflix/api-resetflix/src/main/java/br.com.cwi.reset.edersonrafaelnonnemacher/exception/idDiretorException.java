package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class idDiretorException extends Exception {
    public idDiretorException(Integer id) {
        super("Nenhum diretor encontrado com o parâmetro id = " + id +", favor verifique os parâmetros informados.");
    }
}