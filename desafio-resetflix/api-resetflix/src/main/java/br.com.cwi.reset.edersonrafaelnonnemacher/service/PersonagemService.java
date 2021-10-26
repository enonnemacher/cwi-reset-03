package br.com.cwi.reset.edersonrafaelnonnemacher.service;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ConsultaIdInvalidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.PersonagemAtor;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.PersonagemRepository;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.PersonagemRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.validator.ValidaPersonagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

//    private FakeDatabase fakeDatabase;
//    public static Integer id = 1;
//    private AtorService atorService;
//
//    public PersonagemService(FakeDatabase fakeDatabase) {
//        this.fakeDatabase = fakeDatabase;
//        //this.atorService = new AtorService();
//    }

    /*
    // 1.1 - Cadastrar personagem
    public List<PersonagemAtor> criarPersonagem(List<PersonagemRequest> personagemRequest) throws Exception {

        List<PersonagemAtor> personagensAtor = new ArrayList<>();

        for (PersonagemRequest personagemRequest1 : personagemRequest) {

            new ValidaPersonagem().accept(personagemRequest1.getIdAtor(),
                    personagemRequest1.getNomePersonagem(),
                    personagemRequest1.getDescricaoPersonagem(),
                    personagemRequest1.getTipoAtuacao());

            PersonagemAtor personagemAtor = new PersonagemAtor(id++,
                    atorService.consultarAtor(id),
                    personagemRequest1.getNomePersonagem(),
                    personagemRequest1.getDescricaoPersonagem(),
                    personagemRequest1.getTipoAtuacao());

            this.fakeDatabase.persistePersonagem(personagemAtor);
            personagensAtor.add(personagemAtor);
        }

        return personagensAtor;
    }*/

    // 1.2 - Consultar personagem pelo id
    public PersonagemAtor consultarPersonagem(Integer id) throws Exception {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        List<PersonagemAtor> listaPersonagens = personagemRepository.findAll();

        for (PersonagemAtor personagemAtor : listaPersonagens) {
            if (personagemAtor.getId() == id) {
                return personagemAtor;
            }
        }

        throw new ConsultaIdInvalidoException(TipoDominioException.PERSONAGEM.getSingular(), id);
    }
}
