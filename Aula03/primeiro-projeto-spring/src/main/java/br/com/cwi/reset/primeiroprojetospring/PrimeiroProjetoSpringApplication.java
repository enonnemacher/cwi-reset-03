package br.com.cwi.reset.primeiroprojetospring;

import br.com.cwi.reset.primeiroprojetospring.domain.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class PrimeiroProjetoSpringApplication {

    public static void main(String[] args) throws AvaliacaoForaDoPadraoException {
        SpringApplication.run(PrimeiroProjetoSpringApplication.class, args);

        LocalDate dataNascimento = LocalDate.of(1960, 8, 05);

        Diretor diretor = new Diretor("Christopher Nolan", dataNascimento, 50, Genero.MASCULINO);
        diretor.imprimirInformacoes();

        Ator ator = new Ator("Teste", dataNascimento, 10, Genero.FEMININO);
        ator.imprimirInformacoes();

        Filme interestelar = new Filme("Interestelar", "Filme muito bom", 120, 2014, 5.0, diretor);
        Filme batman = new Filme("Batman", "Filme muito bom", 120, 2011, 4.8, diretor);

        interestelar.reproduzir();
        batman.reproduzir();
    }
}
