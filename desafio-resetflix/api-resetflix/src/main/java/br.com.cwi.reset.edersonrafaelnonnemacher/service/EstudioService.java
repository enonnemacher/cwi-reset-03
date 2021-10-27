package br.com.cwi.reset.edersonrafaelnonnemacher.service;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ConsultaIdInvalidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.FiltroNomeNaoEncontradoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ListaVaziaException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Estudio;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.EstudioRepository;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.EstudioRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.validator.ValidaEstudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    // 3.1 Cadastrar estudio
    public void criarEstudio(EstudioRequest estudioRequest) throws Exception {

        new ValidaEstudio().accept(estudioRequest.getNome(), estudioRequest.getDataCriacao(),
                TipoDominioException.ESTUDIO);

        estudioRepository.save(new Estudio(estudioRequest.getNome(), estudioRequest.getDescricao(),
                estudioRequest.getDataCriacao(), estudioRequest.getStatusAtividade()));
    }

    // 3.2 Listar Estudio
    public List<Estudio> consultarEstudios(String filtroNome) throws Exception {

        List<Estudio> buscaEstudios = new ArrayList<>();
        List<Estudio> listaEstudios = estudioRepository.findAll();

        if (listaEstudios.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ESTUDIO.getSingular(), TipoDominioException.ESTUDIO.getPlural());
        } else {
            for (Estudio estudio : listaEstudios) {
                if (estudio.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
                    buscaEstudios.add(estudio);
                }
                if (buscaEstudios.isEmpty()) {
                    throw new FiltroNomeNaoEncontradoException("Estudio", filtroNome);
                }
            }
        }
        return buscaEstudios;
    }

    // 3.3 Consultar estudio
    public Estudio consultarEstudio(Integer id) throws Exception {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<Estudio> listaEstudios = estudioRepository.findAll();

        for (Estudio estudio : listaEstudios) {
            if (estudio.getId() == id) {
                return estudio;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.ESTUDIO.getSingular(), id);
    }
}
