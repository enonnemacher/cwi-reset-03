package br.com.cwi.reset.edersonrafaelnonnemacher.service;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ConsultaIdInvalidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.FiltroNomeNaoEncontradoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ListaVaziaException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.StatusCarreira;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.AtorRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.validator.ValidaAtor;
import br.com.cwi.reset.edersonrafaelnonnemacher.response.AtorEmAtividade;

import java.util.*;

public class AtorService {

    private FakeDatabase fakeDatabase;

    public static Integer id = 1;

    public AtorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // 1.1 Cadastrar ator
    public void criarAtor(AtorRequest atorRequest) throws Exception {

        new ValidaAtor().accept(atorRequest.getNome(), atorRequest.getDataNascimento(), atorRequest.getAnoInicioAtividade(), atorRequest.getStatusCarreira(), TipoDominioException.ATOR);

        this.fakeDatabase.persisteAtor(new Ator(id++, atorRequest.getNome(), atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade()));
    }

    // 1.2 - listar atores em atividade - filtrar por nome
    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {

        List<AtorEmAtividade> buscaAtores = new ArrayList<>();
        List<Ator> listaAtores = fakeDatabase.recuperaAtores();

        if (listaAtores.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        }
        if (filtroNome != null) {
            for (Ator ator : listaAtores) {
                final boolean containsFilter = ator.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (containsFilter && emAtividade) {
                    buscaAtores.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        } else {
            for (Ator ator : listaAtores) {
                final boolean emAtividade = StatusCarreira.EM_ATIVIDADE.equals(ator.getStatusCarreira());
                if (emAtividade) {
                    buscaAtores.add(new AtorEmAtividade(ator.getId(), ator.getNome(), ator.getDataNascimento()));
                }
            }
        }

        if (buscaAtores.isEmpty()) {
            throw new FiltroNomeNaoEncontradoException("Ator", filtroNome);
        }

        return buscaAtores;
    }

    // 1.3 - Consultar ator id
    public Ator consultarAtor(Integer id) throws Exception {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<Ator> listaAtores = fakeDatabase.recuperaAtores();

        for (Ator ator : listaAtores) {
            if (ator.getId() == id) {
                return ator;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
    }

    // 1.4 - listar todos os atores
    public List consultarAtores() throws Exception {
        List<Ator> listaAtores = fakeDatabase.recuperaAtores();
        if (listaAtores.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        } else {
            return listaAtores;
        }
    }
}
