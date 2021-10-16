package br.com.cwi.reset.primeiroprojetospring.domain;

public class AvaliacaoForaDoPadraoException extends Exception {
    public AvaliacaoForaDoPadraoException() {
        super("Avaliação deve ser um valor entre 1 e 5");
    }
}
