package br.com.cwi.reset.edersonrafaelnonnemacher.service;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ConsultaIdInvalidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.FiltroNomeNaoEncontradoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ListaVaziaException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Diretor;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.DiretorRepository;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.DiretorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class DiretorService {

    @Autowired
    private DiretorRepository diretorRepository;

    // 2.1 Cadastrar diretor - diretorRepository
    public void cadastrarDiretor(DiretorRequest diretorRequest) throws Exception {

        diretorRepository.save(new Diretor(diretorRequest.getNome(), diretorRequest.getDataNascimento(),
                diretorRequest.getAnoInicioAtividade()));
    }

    // 2.2 - listar diretores - filtrar por nome - diretorRepository
    public List listarDiretores(String filtroNome) throws Exception {

        List<Diretor> listaDiretores = diretorRepository.findByNome(filtroNome);
        List<Diretor> buscaDiretores = new ArrayList<>();

        if (listaDiretores.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.DIRETOR.getSingular(), TipoDominioException.DIRETOR.getPlural());
        } else {
            for (Diretor diretor : listaDiretores) {
                if (diretor.getNome().toLowerCase(Locale.ROOT).contains(filtroNome.toLowerCase(Locale.ROOT))) {
                    buscaDiretores.add(diretor);
                }
                if (buscaDiretores.isEmpty()) {
                    throw new FiltroNomeNaoEncontradoException("Diretor", filtroNome);
                }
            }
        }
        return buscaDiretores;
    }

    // 2.3 - Consultar diretor id - diretorRepository
    public Diretor consultarDiretor(Integer id) throws Exception {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<Diretor> listaDiretores = diretorRepository.findAll();

        for (Diretor diretor : listaDiretores) {
            if (diretor.getId() == id) {
                return diretor;
            }
        }
        throw new ConsultaIdInvalidoException(TipoDominioException.DIRETOR.getSingular(), id);
    }
}
