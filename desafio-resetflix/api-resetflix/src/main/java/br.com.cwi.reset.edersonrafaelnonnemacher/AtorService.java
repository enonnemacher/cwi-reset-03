package br.com.cwi.reset.edersonrafaelnonnemacher;

// AtorService é onde você vai definir as regras de negócio, as validações e limitações na hora de manipular os atores.

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
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
    public List listarAtoresEmAtividade(String filtroNome) throws ListaAtoresVazioException, AtorNaoEncontradoComFiltro {

        List<Ator> buscaAtores = new ArrayList<>();
        List<Ator> listaAtores = fakeDatabase.recuperaAtores();

        if (listaAtores.isEmpty()) {
            throw new ListaAtoresVazioException();
        } else {
            for (Ator ator : listaAtores) {
                if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                    if (ator.getNome().contains(filtroNome)) {
                        buscaAtores.add(ator);
                    }
                }
                if (buscaAtores.isEmpty()) {
                    throw new AtorNaoEncontradoComFiltro(filtroNome);
                }
            }
        }
        return buscaAtores;
    }

    // 1.2 - listar atores em atividade
    public List listarAtoresEmAtividade() throws ListaAtoresVazioException {

        List<Ator> buscaAtores = new ArrayList<>();
        List<Ator> listaAtores = fakeDatabase.recuperaAtores();

        if (listaAtores.isEmpty()) {
            throw new ListaAtoresVazioException();
        } else {
            for (Ator ator : listaAtores) {
                if (ator.getStatusCarreira().equals(StatusCarreira.EM_ATIVIDADE)) {
                    buscaAtores.add(ator);
                }
            }
        }
        return buscaAtores;
    }


    // 1.3 - Consultar ator id
    public List consultarAtor(Integer id) throws CampoObrigatorioException, idAtorException {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }
        Ator buscaAtor = null;

        List<Ator> listaAtores = fakeDatabase.recuperaAtores();

        for (Ator ator : listaAtores) {
            if (ator.getId() == id) {
                buscaAtor = ator;
            } else {
                throw new idAtorException(id);
            }
        }
        return Arrays.asList(buscaAtor);
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
