package br.com.cwi.reset.edersonrafaelnonnemacher.service;

//import br.com.cwi.reset.edersonrafaelnonnemacher.exception.FilmeNaoEncontradoException;
//import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ListaVaziaException;
//import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Filme;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.PersonagemAtor;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.FilmeRepository;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.FilmeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;
    private PersonagemService personagemService;
    private EstudioService estudioService;
    private DiretorService diretorService;


    // 4.1 Criar filme
    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        List<PersonagemAtor> personagens = personagemService.criarPersonagem(filmeRequest.getPersonagens());

        filmeRepository.save(new Filme(filmeRequest.getNome(), filmeRequest.getAnoLancamento(), filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(), estudioService.consultarEstudio(filmeRequest.getIdEstudio()), diretorService.consultarDiretor(filmeRequest.getIdDiretor()),
                personagens, filmeRequest.getResumo()));
    }

    // 4.2 - Consultar filmes
    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws Exception {

        List<Filme> listaDosFilmes = filmeRepository.findAll();
        List<Filme> retornoFiltroFilme = new ArrayList<>();

        if (listaDosFilmes.isEmpty()) {
            //throw new ListaVaziaException(TipoDominioException.FILME.getSingular(), TipoDominioException.FILME.getPlural());
        }

        if (nomeFilme.isEmpty() && nomeDiretor.isEmpty() && nomePersonagem.isEmpty() && nomeAtor.isEmpty()) {
            return listaDosFilmes;
        }

        for (Filme buscaFilme : listaDosFilmes) {
            if (buscaFilme.getNome().toLowerCase(Locale.ROOT).contains(nomeFilme.toLowerCase(Locale.ROOT))) {
                retornoFiltroFilme.add(buscaFilme);
            }
            if (buscaFilme.getDiretor().getNome().toLowerCase(Locale.ROOT).contains(nomeDiretor.toLowerCase(Locale.ROOT))) {
                retornoFiltroFilme.add(buscaFilme);
            }
            if (buscaFilme.getPersonagens().contains(nomePersonagem.toLowerCase(Locale.ROOT))) {
                retornoFiltroFilme.add(buscaFilme);
            }
            for (PersonagemAtor ator : buscaFilme.getPersonagens()) {
                if (buscaFilme.getPersonagens().contains(ator.getAtor().getNome().toLowerCase(Locale.ROOT))) {
                    retornoFiltroFilme.add(buscaFilme);
                }
            }
        }

        if (retornoFiltroFilme.isEmpty()) {
            //throw new FilmeNaoEncontradoException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
        }

        return retornoFiltroFilme;
    }
}
