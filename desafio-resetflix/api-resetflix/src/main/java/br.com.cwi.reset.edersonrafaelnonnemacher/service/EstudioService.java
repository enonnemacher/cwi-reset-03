package br.com.cwi.reset.edersonrafaelnonnemacher.service;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ConsultaIdInvalidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.FiltroNomeNaoEncontradoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ListaVaziaException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Estudio;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.EstudioRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.validator.ValidaEstudio;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EstudioService {

    private FakeDatabase fakeDatabase;

    public static Integer id = 1;

    public EstudioService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // 3.1 Cadastrar estudio
    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

        new ValidaEstudio().accept(estudioRequest.getNome(), estudioRequest.getDescricao(), estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade(), TipoDominioException.ESTUDIO);

        this.fakeDatabase.persisteEstudio(new Estudio(id++, estudioRequest.getNome(), estudioRequest.getDescricao(),
                estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade()));
    }

    // 3.2 Listar estudio
    public List<Estudio> listarEstudios(String filtroNome) throws Exception {

        List<Estudio> buscaEstudios = new ArrayList<>();
        List<Estudio> listaEstudios = fakeDatabase.recuperaEstudios();

        if (listaEstudios.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ESTUDIO.getSingular(), TipoDominioException.ESTUDIO.getPlural());
        }

        if (filtroNome != null) {
            for (Estudio estudio : listaEstudios) {
                final boolean containsFilter = estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT));
                if (containsFilter) {
                    buscaEstudios.add(estudio);
                }
            }
        } else {
            return buscaEstudios;
        }

        if (buscaEstudios.isEmpty()) {
            throw new FiltroNomeNaoEncontradoException("Estudio", filtroNome);
        }

        return buscaEstudios;
    }

    // 3.3 Consultar estudio
    public Estudio consultarEstudio(Integer id) throws Exception {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<Estudio> listaEstudios = fakeDatabase.recuperaEstudios();

        for (Estudio estudio : listaEstudios) {
            if (estudio.getId() == id) {
                return estudio;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.ESTUDIO.getSingular(), id);
    }
}
