package br.com.cwi.reset.edersonrafaelnonnemacher.repository;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Diretor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DiretorRepository extends CrudRepository<Diretor, Integer> {

    List<Diretor> findByNome(String nome);

    Diretor save(Diretor diretor);

    List<Diretor> findAll();
}