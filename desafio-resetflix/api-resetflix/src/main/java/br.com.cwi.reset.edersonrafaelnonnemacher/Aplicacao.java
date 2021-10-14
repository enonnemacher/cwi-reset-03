package br.com.cwi.reset.edersonrafaelnonnemacher;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) throws CampoObrigatorioException, MesmoNomeException, atorSemSobrenomeException, dataNascimentoMaiorException, ParseException, anoAtividadeMaiorNascimentoException, ListaAtoresVazioException, idAtorException, diretorSemSobrenomeException, dataNascimentoMaiorDiretorException, anoAtividadeMaiorNascimentoDiretorException, idDiretorException {

        FakeDatabase fakeDatabase = new FakeDatabase();

        AtorService atorService = new AtorService(fakeDatabase);
        DiretorService diretorService = new DiretorService(fakeDatabase);

        String nome = "Will Smith";
        LocalDate dataNascimento = LocalDate.of(1968, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade = 1986;
        AtorRequest atorRequest = new AtorRequest(nome, dataNascimento, statusCarreira, anoInicioAtividade);

        String nome2 = "Daniel Craig";
        LocalDate dataNascimento2 = LocalDate.of(1930, Month.SEPTEMBER, 25);
        StatusCarreira statusCarreira2 = StatusCarreira.EM_ATIVIDADE;
        Integer anoInicioAtividade2 = 1970;
        AtorRequest atorRequest2 = new AtorRequest(nome2, dataNascimento2, statusCarreira2, anoInicioAtividade2);

        String nome3 = "Quentin Tarantino";
        LocalDate dataNascimento3 = LocalDate.of(1940, Month.SEPTEMBER, 25);
        Integer anoInicioAtividade3 = 1970;
        DiretorRequest diretorRequest = new DiretorRequest(nome3, dataNascimento3, anoInicioAtividade3);

        atorService.criarAtor(atorRequest);
        atorService.criarAtor(atorRequest2);
        diretorService.cadastrarDiretor(diretorRequest);

        List<Ator> atores = fakeDatabase.recuperaAtores();
        List<Diretor> diretores = fakeDatabase.recuperaDiretores();

        System.out.println("Primeiro ator deve ser 'Will Smith', valor encontrado: " + atores.get(0).getNome());
        System.out.println("Segundo ator deve ser 'Daniel Craig', valor encontrado: " + atores.get(1).getNome());
        System.out.println("Deve conter 1 diretor, quantidade encontrada: " + diretores.size());

    }
}
