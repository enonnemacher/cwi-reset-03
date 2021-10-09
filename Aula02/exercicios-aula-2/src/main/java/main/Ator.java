package main;

public class Ator {

    private String nome;
    private int idade;
    private int numeroOscar;
    private Genero genero;

    public Ator(String nome, int idade, int numeroOscar, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.numeroOscar = numeroOscar;
        this.genero = genero;
    }

    public void retornaDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Gênero: " + this.genero);
    }
}
