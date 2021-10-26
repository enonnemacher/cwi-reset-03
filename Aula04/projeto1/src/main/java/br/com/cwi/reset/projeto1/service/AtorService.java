package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.AtorJaExistenteException;
import br.com.cwi.reset.projeto1.exception.AtorNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.AtorRepositoryBd;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AtorService {

    @Autowired
    private AtorRepositoryBd repository;

    public Ator cadastrarAtor(Ator ator) throws AtorJaExistenteException {
        Ator atorJaExistente = repository.findByNome(ator.getNome());

        if (atorJaExistente != null) {
            throw new AtorJaExistenteException("Ator com o nome " + ator.getNome() + " já existe.");
        }

        return repository.save(ator);
    }

    public Ator buscarAtorPeloNome(String nome) throws AtorNaoExistenteException {
        Ator ator = repository.findByNome(nome);

        if (ator == null) {
            throw new AtorNaoExistenteException("Ator com o nome " + nome + "não existe.");
        }
        return ator;
    }

    public List<Ator> buscarAtorNumeroOscars(Integer numero) {
        List<Ator> atores = new ArrayList<>();
        return atores = repository.findByOscar(numero);
    }

    public void deletarAtor(Integer idAtor) throws AtorNaoExistenteException {
        Ator ator = repository.findById(idAtor);

        if (ator == null) {
            throw new AtorNaoExistenteException("Ator com o nome " + ator.getNome() + "não existe.");
        }
        repository.delete(ator.getId());
    }
}
