package br.com.cwi.reset.projeto1.domain;

import java.time.LocalDate;

public class Diretor extends Pessoa {
    private Integer quantidadeFilmes;

    public Diretor(String nome, LocalDate nascimento, Integer quantidadeFilmes, Genero genero) {
        super(nome, nascimento, genero);
        this.quantidadeFilmes = quantidadeFilmes;
    }

    public Integer getQuantidadeFilmes() {
        return quantidadeFilmes;
    }
}
