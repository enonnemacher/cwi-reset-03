package br.com.cwi.reset.edersonrafaelnonnemacher;

// AtorService é onde você vai definir as regras de negócio, as validações e limitações na hora de manipular os atores.

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public static Integer id = 1;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // 1.1 Cadastrar ator
    public void criarAtor(AtorRequest atorRequest) throws CampoObrigatorioException, MesmoNomeException, atorSemSobrenomeException, ParseException, dataNascimentoMaiorException, anoAtividadeMaiorNascimentoException {

        if (atorRequest.getNome().isEmpty()) {
            throw new CampoObrigatorioException("nome.");
        }
        if (atorRequest.getDataNascimento() == null) {
            throw new CampoObrigatorioException("data de nascimento.");
        }
        if (atorRequest.getStatusCarreira() == null) {
            throw new CampoObrigatorioException("status da carreira.");
        }
        if (atorRequest.getAnoInicioAtividade() == null) {
            throw new CampoObrigatorioException("ano do início de atividade.");
        }

        String nomeAtor[] = atorRequest.getNome().split("\\S+");
        if (nomeAtor.length < 2) {
            throw new atorSemSobrenomeException(atorRequest.getNome());
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataNascimento = dateFormat.parse(atorRequest.getDataNascimento().toString());
        Date dataHoje = dateFormat.parse(LocalDate.now().toString());
        if (dataNascimento.after(dataHoje)) {
            throw new dataNascimentoMaiorException();
        }

        if (atorRequest.getDataNascimento().getYear() - atorRequest.getAnoInicioAtividade() >= 0) {
            throw new anoAtividadeMaiorNascimentoException();
        }

        for (Ator listaDeAtores : fakeDatabase.recuperaAtores()) {
            if (listaDeAtores.getNome().equals(atorRequest.getNome())) {
                throw new MesmoNomeException(atorRequest.getNome());
            }
        }

        this.fakeDatabase.persisteAtor(new Ator(id++, atorRequest.getNome(), atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade()));
    }

    // 1.2 - listar atores em atividade - filtrar por nome

    // 1.3 - Consultar ator id - ajustar - Verificar ERRO
    public List consultarAtores(Integer id) throws CampoObrigatorioException, idAtorException {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<Ator> listaAtores = fakeDatabase.recuperaAtores();
        Ator buscaAtor = null;

        for (Ator ator : listaAtores) {
            if (ator.getId().equals(id)) {
                buscaAtor = ator;

            } else {
                throw new idAtorException(id);
            }
        }
    }

    // 1.4 - listar todos os atores
    public List consultarAtores() throws ListaAtoresVazioException {
        List<Ator> listaAtores = fakeDatabase.recuperaAtores();
        if (listaAtores.isEmpty()) {
            throw new ListaAtoresVazioException();
        } else {
            return listaAtores;
        }
    }
}
