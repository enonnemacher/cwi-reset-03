package br.com.cwi.reset.edersonrafaelnonnemacher;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) throws CampoObrigatorioException, MesmoNomeException, atorSemSobrenomeException, dataNascimentoMaiorException, ParseException, anoAtividadeMaiorNascimentoException, ListaAtoresVazioException, idAtorException {

        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        atorService.criarAtor(atorRequest);

        List<Ator> atores = fakeDatabase.recuperaAtores();

        System.out.println("Deve conter 1 ator, quantidade encontrada: " + atores.size());
        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());

        // Teste de consultar ator pelo id
        System.out.println(atorService.consultarAtores(1));

    }
}
