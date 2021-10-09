package main;

import java.time.LocalDate;

public class Aplicacao {
    public static void main(String[] args) {

        LocalDate dataNascimento = LocalDate.of(1960, 8, 05);

        Diretor quentinTarantino = new Diretor("Quentin Tarantino", dataNascimento, Genero.MASCULINO, 30);
        Ator danielCraig = new Ator("Daniel Craig", dataNascimento, Genero.MASCULINO, 2);

        Filme django = new Filme("Django", "Filme de ação", 120, 2016, 5, quentinTarantino);
        Filme pulpFiction = new Filme("Pulp fiction", "Filme de ação", 130, 1997, 5, quentinTarantino);

        try {
            django.validaAvaliacao();
        } catch (AvaliacaoForaDoPadraoException e) {
            System.out.println(e.getMessage());
        }

        try {
            pulpFiction.validaAvaliacao();
        } catch (AvaliacaoForaDoPadraoException e) {
            System.out.println(e.getMessage());
        }

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
