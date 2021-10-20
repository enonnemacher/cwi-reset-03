package br.com.cwi.reset.edersonrafaelnonnemacher.validator;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.ConsultaIdInvalidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoRepetidoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Genero;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.PersonagemRequest;

import java.util.ArrayList;
import java.util.List;

public class ValidaFilme {

    public void accept(final String nome, final Integer anoLancamento, final String capaFilme,
                       final List<Genero> generos, final Integer idDiretor, final Integer idEstudio,
                       final String resumo, final List<PersonagemRequest> personagens) throws Exception {

        if (nome == null) {
            throw new CampoObrigatorioException("nome.");
        }

        if (anoLancamento == null) {
            throw new CampoObrigatorioException("anoLancamento.");
        }

        if (capaFilme == null) {
            throw new CampoObrigatorioException("capaFilme.");
        }

        if (generos == null) {
            throw new CampoObrigatorioException("generos.");
        }

        if (idDiretor == null) {
            throw new ConsultaIdInvalidoException(TipoDominioException.DIRETOR.getSingular(), idDiretor);
        }

        if (idEstudio == null) {
            throw new ConsultaIdInvalidoException(TipoDominioException.ESTUDIO.getSingular(), idEstudio);
        }

        if (resumo == null) {
            throw new CampoObrigatorioException("resumo.");
        }

        if (personagens == null) {
            throw new CampoObrigatorioException("personagens.");
        }

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
