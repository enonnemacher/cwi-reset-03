package br.com.cwi.reset.projeto1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExemplosAula {

    public static void main(String[] args) {

//        List<String> nomes = new ArrayList<>();
//
//        nomes.add("Leonardo");
//        nomes.add("Neto");
//        nomes.add("Bruno");
//        nomes.add("Pablo");
//
//        List<String> palavrasQueComecemPorL = filtrarPalavrasQueComecemPor(nomes, 'L');
//
//        for (String nome : palavrasQueComecemPorL) {
//            System.out.println("Nome: " + nome);
//        }
//
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao sistema de calculo de IMC");
        String opcao = "";

        while (!opcao.equals(":q")) {
            System.out.println("ABBBBBB - Para calcular o IMC");
            opcao = scanner.nextLine();
            if (opcao.equals("A")) {
                System.out.println("Digite a altura (m)");
                double altura = scanner.nextDouble();

                System.out.println("Digite o Peso (kg)");
                double peso = scanner.nextDouble();

                double imc = calcularImc(peso, altura);
                String classificacao = consultarClassificacaoImc(imc);

                System.out.println("IMC Calculado: " + imc);
                System.out.println("O paciente se encontra em: " + classificacao);
            }
        }











//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Digite sua Altura: ");
//        double altura = scanner.nextDouble();
//
//        System.out.println("Altura escolhida: " + altura);
    }

    private static List<String> filtrarPalavrasQueComecemPor(List<String> palavras, char letraInicial) {
        List<String> palavrasFiltradas = new ArrayList<>();
        for (int i = 0; i < palavras.size(); i++) {
            String palavra = palavras.get(i);
            if (palavra.charAt(0) == letraInicial) {
                palavrasFiltradas.add(palavra);
            }
        }
        return palavrasFiltradas;
    }

    private static double calcularImc(double peso, double altura) {
        return peso / (altura * altura);
    }

    private static String consultarClassificacaoImc(double imc) {
        String classificacao;
        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
        } else if (imc < 25) {
            classificacao = "Peso Normal";
        } else if (imc < 30) {
            classificacao = "Sobrepeso";
        } else if (imc < 35) {
            classificacao = "Obesidade Grau 1";
        } else if (imc < 40) {
            classificacao = "Obesidade Grau 2";
        } else {
            classificacao = "Obesidade Grau 3 ou Mórbida";
        }
        return classificacao;
    }
}
