package br.com.cwi.reset.edersonrafaelnonnemacher;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;

@SpringBootApplication
public class Aplicacao {
    public static void main(String[] args) throws CampoObrigatorioException, MesmoNomeException, atorSemSobrenomeException, dataNascimentoMaiorException, ParseException, anoAtividadeMaiorNascimentoException, ListaAtoresVazioException, idAtorException, diretorSemSobrenomeException, dataNascimentoMaiorDiretorException, anoAtividadeMaiorNascimentoDiretorException, idDiretorException {

        SpringApplication.run(Aplicacao.class, args);
    }
}
