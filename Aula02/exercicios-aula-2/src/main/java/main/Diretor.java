package main;

public class Diretor {

    private String nome;
    private int idade;
    private int quantidadeFilmes;
    private Genero genero;

    public Diretor(String nome, int idade, int quantidadeFilmes, Genero genero) {
        this.nome = nome;
        this.idade = idade;
        this.quantidadeFilmes = quantidadeFilmes;
        this.genero = genero;
    }

    public String getNome() {
        return nome;
    }

    public void retornaDados() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Gênero: " + this.genero.getDescricao());
    }
}
