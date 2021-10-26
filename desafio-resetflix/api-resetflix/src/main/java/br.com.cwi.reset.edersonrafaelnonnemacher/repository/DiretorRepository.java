package br.com.cwi.reset.edersonrafaelnonnemacher.repository;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, Integer> {

    List<Diretor> findByNome(String nome);

    List<Diretor> findAll();
}