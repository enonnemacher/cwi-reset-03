package main;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Quentin Tarantino", 60, 30, Genero.MASCULINO);
        Ator ator = new Ator("Daniel Craig", 53, 2, Genero.MASCULINO);

        Filme django = new Filme("Django", "Filme ação", 120, 2016, 5, diretor);
        Filme pulpFiction = new Filme("Pulp fiction", "Filme ação", 130, 1997, 5, diretor);

        django.reproduzir();
        System.out.println();
        pulpFiction.reproduzir();
        System.out.println();
        System.out.println("Dados do diretor:");
        diretor.retornaDados();
        System.out.println();
        System.out.println("Dados do ator:");
        ator.retornaDados();
    }
}
