package br.com.cwi.reset.edersonrafaelnonnemacher.validator;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoRepetidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Genero;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.FilmeRepository;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.PersonagemRequest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class ValidaFilme {

    @Autowired
    private FilmeRepository filmeRepository;

    public void accept(final List<Genero> generos, final List<PersonagemRequest> personagens) throws Exception, CampoRepetidoException {

        List<Genero> listaGeneros = new ArrayList<>();
        for (Genero genero : generos) {
            if (listaGeneros.contains(genero)) {
                throw new CampoRepetidoException("gênero");
            } else {
                listaGeneros.add(genero);
            }
        }

        List<PersonagemRequest> listaPersonagens = new ArrayList<>();
        for (PersonagemRequest personagemAtor : personagens) {
            if (listaPersonagens.contains(personagemAtor)) {
                throw new CampoRepetidoException("ator/personagem");
            } else {
                listaPersonagens.add(personagemAtor);
            }
        }
    }
}
