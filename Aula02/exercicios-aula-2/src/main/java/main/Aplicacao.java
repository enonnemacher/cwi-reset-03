package main;

public class Aplicacao {
    public static void main(String[] args) {

        Filme filme1 = new Filme("007", "Filme de ação", 130, 2021, 5, "Fulano", 50, 7);
        Filme filme2 = new Filme("Hitman", "Filme de ação", 120, 2015, 5, "Ciclano", 60, 3);

        System.out.println(filme1.toString());
        System.out.println();
        System.out.println(filme2.toString());
    }
}
