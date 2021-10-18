package br.com.cwi.reset.edersonrafaelnonnemacher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class Aplicacao {
    public static void main(String[] args) throws CampoObrigatorioException, MesmoNomeException, atorSemSobrenomeException, dataNascimentoMaiorException, ParseException, anoAtividadeMaiorNascimentoException, ListaAtoresVazioException, idAtorException, diretorSemSobrenomeException, dataNascimentoMaiorDiretorException, anoAtividadeMaiorNascimentoDiretorException, idDiretorException {

        SpringApplication.run(Aplicacao.class, args);
    }
}
