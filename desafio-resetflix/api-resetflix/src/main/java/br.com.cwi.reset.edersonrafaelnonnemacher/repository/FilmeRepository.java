package br.com.cwi.reset.edersonrafaelnonnemacher.repository;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Filme;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmeRepository extends CrudRepository<Filme, Integer> {

    Filme findByNome(String nome);

    Filme save(Filme filme);

    List<Filme> findAll();
}