package br.com.cwi.reset.projeto1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {
        int soma = 0;
        for (int i = 0; i < numeros.size(); i++) {
            soma += numeros.get(i);
        }
        return soma;
    }

    public Double calcularMedia(List<Integer> numeros) {
        double media = 0.0;
        for (int i = 0; i < numeros.size(); i++) {
            media += numeros.get(i);
        }
        return media / numeros.size();
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        int valor = 0;
        int auxiliar = 0;
        for (int i = 0; i < numeros.size(); i++) {
            auxiliar = numeros.get(i);
            if (auxiliar > valor) {
                valor = auxiliar;
            }
        }
        return valor;
    }

    public String obterPalavraInvertida(String palavra) {
        String palavraInvertida = "";
        for (int i = palavra.length() - 1; i >= 0; i--) {
            palavraInvertida += palavra.charAt(i);
        }
        return palavraInvertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        int auxiliar = 0;
        Integer[] listaFinal = numeros.toArray(new Integer[numeros.size()]);
        for (int i = 0; i < numeros.size(); i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                if(listaFinal[j] < listaFinal[i]){
                    auxiliar = listaFinal[j];
                    listaFinal[j] = listaFinal[i];
                    listaFinal[i] = auxiliar;
                }
            }
        }
        return Arrays.asList(listaFinal);
    }
}

