package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Filme;
import br.com.cwi.reset.projeto1.exception.FilmeJaExistenteException;
import br.com.cwi.reset.projeto1.exception.FilmeNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.FilmeRepository;

import java.util.List;

public class FilmeService {

    private FilmeRepository repository = new FilmeRepository();

    public Filme salvar(Filme filme) throws FilmeJaExistenteException {
       Filme filmeJaExistente = repository.findByNome(filme.getNome());

       if (filmeJaExistente != null) {
           throw new FilmeJaExistenteException("Filme com o nome " + filme.getNome() + " já existe");
       }
       repository.save(filme);
       return filme;
    }

    public List<Filme> listarTodos() {
        return repository.findAll();
    }

    public Filme buscarPorNome(String nome) {
        return repository.findByNome(nome);
    }

    public void deletar(String nomeFilme) throws FilmeNaoExistenteException {
        Filme filme = buscarPorNome(nomeFilme);
        if (filme == null) {
            throw new FilmeNaoExistenteException("Filme com o nome " + nomeFilme + " não existe");
        }
        repository.delete(filme);
    }

    public Filme atualizar(Filme filme) throws FilmeNaoExistenteException {
        Filme filmeJaCadastrado = buscarPorNome(filme.getNome());
        if (filme == null) {
            throw new FilmeNaoExistenteException("Filme com o nome " + filme.getNome() + " não existe");
        }
        return repository.update(filme);
    }
}
