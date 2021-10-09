package main;

public class Diretor {

        private String nome;
        private int idade;
        private int quantidadeFilmes;

    public Diretor(String nome, int idade, int quantidadeFilmes) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmes = quantidadeFilmes;
    }

    public String getNome() {
        return nome;
    }
}
