package br.com.cwi.reset.edersonrafaelnonnemacher.service;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.FilmeNaoEncontradoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ListaVaziaException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Filme;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.PersonagemAtor;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.FilmeRepository;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.FilmeRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.PersonagemRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.validator.ValidaFilme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    private FakeDatabase fakeDatabase;
    private DiretorService diretorService;
    private PersonagemService personagemService;
    private EstudioService estudioService;
    public static Integer id = 1;

//    public FilmeService(FakeDatabase fakeDatabase) {
//        this.fakeDatabase = fakeDatabase;
//        this.diretorService = new DiretorService(FakeDatabase.getInstance());
//        this.personagemService = new PersonagemService(FakeDatabase.getInstance());
//        this.estudioService = new EstudioService(FakeDatabase.getInstance());
//    }

    /*
    // 4.1 Criar filme
    public void criarFilme(FilmeRequest filmeRequest) throws Exception {

        new ValidaFilme().accept(filmeRequest.getNome(),
                filmeRequest.getAnoLancamento(),
                filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(),
                filmeRequest.getIdDiretor(),
                filmeRequest.getIdEstudio(),
                filmeRequest.getResumo(),
                filmeRequest.getPersonagens());

        List<PersonagemAtor> personagens = personagemService.criarPersonagem(filmeRequest.getPersonagens());

        this.fakeDatabase.persisteFilme(new Filme(id++,
                filmeRequest.getNome(),
                filmeRequest.getAnoLancamento(),
                filmeRequest.getCapaFilme(),
                filmeRequest.getGeneros(),
                diretorService.consultarDiretor(filmeRequest.getIdDiretor()),
                estudioService.consultarEstudio(filmeRequest.getIdEstudio()),
                personagens,
                filmeRequest.getResumo()));
    }*/

    // 4.2 - Consultar filmes
    public List<Filme> consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor) throws Exception {

        List<Filme> listaDosFilmes = fakeDatabase.recuperaFilmes();
        List<Filme> retornoFiltroFilme = new ArrayList<>();

        if (listaDosFilmes.isEmpty()) {
            throw new ListaVaziaException(TipoDominioException.FILME.getSingular(), TipoDominioException.FILME.getPlural());
        }

        if (nomeFilme.isEmpty() && nomeDiretor.isEmpty() && nomePersonagem.isEmpty() && nomeAtor.isEmpty()) {
            return listaDosFilmes;
        }

        for (Filme buscaFilme : listaDosFilmes) {
            if (buscaFilme.getNome().contains(nomeFilme)) {
                retornoFiltroFilme.add(buscaFilme);
            }
            if (buscaFilme.getDiretor().getNome().contains(nomeDiretor)) {
                retornoFiltroFilme.add(buscaFilme);
            }
            if (buscaFilme.getPersonagens().contains(nomePersonagem)) {
                retornoFiltroFilme.add(buscaFilme);
            }
            for (PersonagemAtor ator : buscaFilme.getPersonagens()) {
                if (buscaFilme.getPersonagens().contains(ator.getAtor().getNome())) {
                    retornoFiltroFilme.add(buscaFilme);
                }
            }
        }

        if (retornoFiltroFilme.isEmpty()) {
            throw new FilmeNaoEncontradoException(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
        }

        return retornoFiltroFilme;
    }
}
