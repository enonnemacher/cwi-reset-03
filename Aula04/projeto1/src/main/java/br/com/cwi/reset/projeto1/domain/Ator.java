package br.com.cwi.reset.projeto1.domain;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private Integer numeroOscars;

    public Ator(String nome, LocalDate nascimento, Integer numeroOscars, Genero genero) {
        super(nome, nascimento, genero);
        this.numeroOscars = numeroOscars;
    }

}
