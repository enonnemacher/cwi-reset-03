package br.com.cwi.reset.edersonrafaelnonnemacher.service;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ConsultaIdInvalidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.FiltroNomeNaoEncontradoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ListaVaziaException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Diretor;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.DiretorRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.validator.ValidaDiretor;

import java.util.ArrayList;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public static Integer id = 1;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // 1.1 Cadastrar diretor
    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {

        new ValidaDiretor().accept(diretorRequest.getNome(), diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade(), TipoDominioException.DIRETOR);

        this.fakeDatabase.persisteDiretor(new Diretor(id++, diretorRequest.getNome(),
                diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade()));
    }

    // 1.2 - listar diretores - filtrar por nome
    public List listarDiretores(String filtroNome) throws Exception {

        List<Diretor> buscaDiretores = new ArrayList<>();
        List<Diretor> listaDiretores = fakeDatabase.recuperaDiretores();

        if (listaDiretores.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.DIRETOR.getSingular(), TipoDominioException.DIRETOR.getPlural());
        } else {
            for (Diretor diretor : listaDiretores) {
                if (diretor.getNome().contains(filtroNome)) {
                    buscaDiretores.add(diretor);
                }
                if (buscaDiretores.isEmpty()) {
                    throw new FiltroNomeNaoEncontradoException("Diretor", filtroNome);
                }
            }
        }
        return buscaDiretores;
    }

    // 1.3 - Consultar diretor id
    public Diretor consultarDiretor(Integer id) throws Exception {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<Diretor> listaDiretores = fakeDatabase.recuperaDiretores();

        for (Diretor diretor : listaDiretores) {
            if (diretor.getId() == id) {
                return diretor;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.DIRETOR.getSingular(), id);
    }
}
