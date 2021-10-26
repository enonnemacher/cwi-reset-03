package br.com.cwi.reset.edersonrafaelnonnemacher.service;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ConsultaIdInvalidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.FiltroNomeNaoEncontradoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ListaVaziaException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.MesmoNomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.StatusCarreira;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.AtorRepository;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.AtorRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.response.AtorEmAtividade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    // 1.1 Cadastrar ator
    public void criarAtor(AtorRequest atorRequest) {

        atorRepository.save(new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(),
                atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade()));
    }

    // 1.2 - listar atores em atividade - filtrar por nome
    public List<AtorEmAtividade> listarAtoresEmAtividade(String filtroNome) throws Exception {

        List<AtorEmAtividade> buscaAtores = new ArrayList<>();
        List<Ator> listaAtores = atorRepository.findAll();

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

    // 1.3 - Consultar ator id - atorRepository
    public Ator consultarAtor(Integer id) throws Exception {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<Ator> listaAtores = atorRepository.findAll();

        for (Ator ator : listaAtores) {
            if (ator.getId() == id) {
                return ator;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
    }

    // 1.4 - listar todos os atores - atorRepository
    public List consultarAtores() throws ListaVaziaException {
        List<Ator> listaAtores = atorRepository.findAll();
        if (listaAtores.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.ATOR.getSingular(), TipoDominioException.ATOR.getPlural());
        } else {
            return listaAtores;
        }
    }

    // 1.5 - atualizar ator
    public void atualizarAtor(Integer id, AtorRequest atorRequest) throws CampoObrigatorioException, ConsultaIdInvalidoException, MesmoNomeException {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<Ator> listaAtores = atorRepository.findAll();

        for (Ator ator : listaAtores) {
            if (ator.getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(atorRequest.getNome().toLowerCase(Locale.ROOT))){
                throw new MesmoNomeException(TipoDominioException.ATOR.getSingular());
            }
            if (ator.getId().equals(id)) {
                atorRepository.save(new Ator(atorRequest.getNome(), atorRequest.getDataNascimento(),
                        atorRequest.getStatusCarreira(), atorRequest.getAnoInicioAtividade()));
            } else {
                throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
            }
        }
    }

    // 1.6 - remover ator
    public void removerAtor(Integer id) throws CampoObrigatorioException, ConsultaIdInvalidoException {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<Ator> listaAtores = atorRepository.findAll();

        for (Ator ator : listaAtores) {
            if (ator.getId().equals(id)) {
                atorRepository.delete(ator);
            } else {
                throw new ConsultaIdInvalidoException(TipoDominioException.ATOR.getSingular(), id);
            }
        }
    }
}
