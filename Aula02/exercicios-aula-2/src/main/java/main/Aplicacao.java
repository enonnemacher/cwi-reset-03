package main;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor diretor = new Diretor("Tarantino", 60, 30);

        Filme django = new Filme("Django", "Filme ação", 120, 2016, 5, diretor);
        Filme pulpFiction = new Filme("Pulp fiction", "Filme ação", 120, 1997, 5, diretor);

        django.reproduzir();
        System.out.println();
        pulpFiction.reproduzir();
    }
}
