package main;

public class Aplicacao {
    public static void main(String[] args) {

        Diretor quentinTarantino = new Diretor("Quentin Tarantino", 60, Genero.MASCULINO, 30);
        Ator danielCraig = new Ator("Daniel Craig", 53, Genero.MASCULINO, 2);

        Filme django = new Filme("Django", "Filme de ação", 120, 2016, 5, quentinTarantino);
        Filme pulpFiction = new Filme("Pulp fiction", "Filme de ação", 130, 1997, 5, quentinTarantino);

        django.reproduzir();
        System.out.println();
        pulpFiction.reproduzir();
        System.out.println();
        System.out.println("Dados do diretor:");
        quentinTarantino.retornaDados();
        System.out.println();
        System.out.println("Dados do ator:");
        danielCraig.retornaDados();
    }
}
