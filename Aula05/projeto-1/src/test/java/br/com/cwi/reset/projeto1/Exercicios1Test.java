package br.com.cwi.reset.projeto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Exercicios1Test {

    // 2.1 -  Validar a soma com uma lista de 5 números inteiros e positivos.
    @Test
    public void testSomarCincoNumerosInteirosEPositivos() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList(5, 7, 12, 18, 15);
        Integer expected = 57;

        // Action
        Integer result = service.somarLista(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 2.2 - Validar a soma com uma lista com 5 elementos, 4 inteiros e 1 negativo
    @Test
    public void testSomarQuatroInteirosEUmNegatio() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList(5, 7, 12, -18, 15);
        Integer expected = 21;

        // Action
        Integer result = service.somarLista(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 2.3 - Validar a soma com uma lista com 3 elementos negativos
    @Test
    public void testSomarTresElementosNegativos() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList(-8, -10, -57);
        Integer expected = -75;

        // Action
        Integer result = service.somarLista(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 2.4 - Validar a soma com uma lista contendo todos elementos como ZERO
    @Test
    public void testSomarTodosElementosZero() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList(0, 0, 0, 0, 0, 0);
        Integer expected = 0;

        // Action
        Integer result = service.somarLista(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 2.5 - Validar a soma com uma lista vazia (sem nenhum valor dentro)
    @Test
    public void testSomarListaVazia() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList();
        Integer expected = 0;

        // Action
        Integer result = service.somarLista(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 3 - Para exatamente os mesmos cenários descritos acima, realizar o teste do método que calcula a média de uma lista.
    // 3.1 -  Validar a média com uma lista de 5 números inteiros e positivos.
    @Test
    public void testMediaCincoNumerosInteirosEPositivos() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList(5, 7, 12, 18, 15);
        Double expected = 11.4;

        // Action
        Double result = service.calcularMedia(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 3.2 - Validar a média com uma lista com 5 elementos, 4 inteiros e 1 negativo
    @Test
    public void testMediaQuatroInteirosEUmNegatio() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList(5, 7, 12, -18, 15);
        Double expected = 4.2;

        // Action
        Double result = service.calcularMedia(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 3.3 - Validar a média com uma lista com 3 elementos negativos
    @Test
    public void testMediaTresElementosNegativos() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList(-8, -10, -57);
        Double expected = -25.0;

        // Action
        Double result = service.calcularMedia(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 3.4 - Validar a média com uma lista contendo todos elementos como ZERO
    @Test
    public void testMediaTodosElementosZero() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList(0, 0, 0, 0, 0, 0);
        Double expected = 0.0;

        // Action
        Double result = service.calcularMedia(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 3.5 - Validar a média com uma lista vazia (sem nenhum valor dentro)
    @Test
    public void testMediaListaVazia() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        List<Integer> numeros = Arrays.asList();
        Double expected = 0.0;

        // Action
        Double result = service.calcularMedia(numeros);

        // Assert
        assertEquals(expected, result);
    }

    // 4. Testar o método que inverte uma palavra passando as seguintes palavras.
    // 4.1 - Abacate
    @Test
    public void testInverteAbacate() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        String palavra = "Abacate";
        String expected = "etacabA";

        // Action
        String result = service.obterPalavraInvertida(palavra);

        // Assert
        assertEquals(expected, result);
    }

    // 4.2 - Banana
    public void testInverteBanana() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        String palavra = "Banana";
        String expected = "ananaB";

        // Action
        String result = service.obterPalavraInvertida(palavra);

        // Assert
        assertEquals(expected, result);
    }

    // 4.3 - Pessego
    public void testInvertePessego() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        String palavra = "Pessego";
        String expected = "ogesseP";

        // Action
        String result = service.obterPalavraInvertida(palavra);

        // Assert
        assertEquals(expected, result);
    }

    // 4.4 - Morango
    public void testInverteMorango() {
        // Arrange
        Exercicios1 service = new Exercicios1();
        String palavra = "Morango";
        String expected = "ognaroM";

        // Action
        String result = service.obterPalavraInvertida(palavra);

        // Assert
        assertEquals(expected, result);
    }
}
