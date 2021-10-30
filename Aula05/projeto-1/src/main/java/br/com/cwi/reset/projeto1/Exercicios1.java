package br.com.cwi.reset.projeto1;

import java.util.Arrays;
import java.util.List;

public class Exercicios1 {

    public Integer somarLista(List<Integer> numeros) {

        Integer sum = 0;
        for (Integer num : numeros) {
            sum += num;
        }
        return sum;
    }

    public Double calcularMedia(List<Integer> numeros) {
        if(numeros.size() == 0){
            return 0.0;
        }
        return (double) somarLista(numeros) / numeros.size();
    }

    public Integer obterMaiorNumero(List<Integer> numeros) {
        Integer maior = numeros.get(0);

        for (Integer num : numeros) {
            if (num > maior) {
                maior = num;
            }
        }
        return maior;
    }

    public String obterPalavraInvertida(String palavra) {
        String invertida = "";

        for (int i = palavra.length() - 1; i >= 0; i--) {
            invertida += palavra.charAt(i);
        }

        return invertida;
    }

    public List<Integer> ordenarLista(List<Integer> numeros) {
        Integer[] ints = numeros.toArray(new Integer[numeros.size()]);
        Integer aux;
        for (int i = 0; i < numeros.size() - 1; i++) {
            for (int j = i + 1; j < numeros.size(); j++) {
                if (ints[j] < ints[i]) {
                    aux = ints[j];
                    ints[j] = ints[i];
                    ints[i] = aux;
                }
            }
        }
        return Arrays.asList(ints);
    }
}

