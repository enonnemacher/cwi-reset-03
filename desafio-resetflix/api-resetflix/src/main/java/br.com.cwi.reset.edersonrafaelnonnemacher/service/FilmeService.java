package br.com.cwi.reset.edersonrafaelnonnemacher.service;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Filme;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.PersonagemAtor;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.FilmeRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.PersonagemRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.validator.ValidaFilme;

import java.util.List;

public class FilmeService {

    private FakeDatabase fakeDatabase;
    private DiretorService diretorService;
    private PersonagemService personagemService;
    private EstudioService estudioService;
    public static Integer id = 1;

    public FilmeService(FakeDatabase fakeDatabase, DiretorService diretorService, PersonagemService personagemService, EstudioService estudioService) {
        this.fakeDatabase = fakeDatabase;
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
        this.personagemService = new PersonagemService(FakeDatabase.getInstance());
        this.estudioService = new EstudioService(FakeDatabase.getInstance());
    }

    // 1.1 Criar filme
    public void criarFilme(FilmeRequest filmeRequest) throws Exception{

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
    }
}
