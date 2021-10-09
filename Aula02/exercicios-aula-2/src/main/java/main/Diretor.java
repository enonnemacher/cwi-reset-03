package main;

import java.time.LocalDate;

public class Diretor extends Pessoa {

    private int quantidadeFilmes;

    public Diretor(String nome, LocalDate dataNascimento, Genero genero, int quantidadeFilmes) {
        super(nome, dataNascimento, genero);
        this.quantidadeFilmes = quantidadeFilmes;
    }
}
