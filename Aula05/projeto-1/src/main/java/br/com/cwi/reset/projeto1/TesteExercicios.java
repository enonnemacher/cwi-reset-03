package br.com.cwi.reset.projeto1;

import java.util.Arrays;
import java.util.List;

public class TesteExercicios {

    public static void main(String[] args) {
        Exercicios1 exercicio = new Exercicios1();

        List<Integer> numeros = Arrays.asList(10, 1564, 200, 120, 15, 12, 144);
        int somaLista = exercicio.somarLista(numeros);
        System.out.println("Resultado esperado -> 2065, Resultado obtido -> " + somaLista);

        double mediaLista = exercicio.calcularMedia(numeros);
        System.out.println("Resultado esperado -> 295, Resultado obtido -> " + mediaLista);

        int maiorNumero = exercicio.obterMaiorNumero(numeros);
        System.out.println("Resultado esperado -> 1564, Resultado obtido -> " + maiorNumero);

        String palavraInvertida = exercicio.obterPalavraInvertida("Leonardo");
        System.out.println("Resultado esperado -> odranoeL, Resultado obtido -> " + palavraInvertida);

        List<Integer> numerosOrdenados = exercicio.ordenarLista(numeros);
        System.out.println("Numeros ordenados: ");

        for (Integer numero : numerosOrdenados) {
            System.out.println(numero);
        }
    }
}
