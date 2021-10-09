package main;

import java.time.LocalDate;

public class Pessoa {

    private String nome;
    //private int idade;
    private LocalDate dataNascimento;
    private Genero genero;

    public Pessoa(String nome, LocalDate dataNascimento, Genero genero) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
    }

    public void retornaDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.dataNascimento);
        System.out.println("Gênero: " + this.genero.getDescricao());
    }

    public String getNome() {
        return nome;
    }
}
