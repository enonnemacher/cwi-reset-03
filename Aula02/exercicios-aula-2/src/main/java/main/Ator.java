package main;

import java.time.LocalDate;

public class Ator extends Pessoa {

    private int numeroOscar;

    public Ator(String nome, LocalDate dataNascimento, Genero genero, int numeroOscar) {
        super(nome, dataNascimento, genero);
        this.numeroOscar = numeroOscar;
    }
}
