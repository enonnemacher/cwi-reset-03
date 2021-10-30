package br.com.cwi.reset.projeto1;

public class CalculadoraService {

    public Integer multiplicar(Integer primeiroNumero, Integer segundoNumero) {
        return primeiroNumero * segundoNumero;
    }

    public Integer somar(Integer primeiroNumero, Integer segundoNumero) {
        return primeiroNumero + segundoNumero;
    }

    public Integer subtrair(Integer primeiroNumero, Integer segundoNumero) {
        return primeiroNumero - segundoNumero;
    }

    public Integer divisao(Integer primeiroNumero, Integer segundoNumero){
        if (segundoNumero == 0){
            throw new ArithmeticException("Divisão por zero não permitida");
        }
        return primeiroNumero / segundoNumero;
    }
}
