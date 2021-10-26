package br.com.cwi.reset.edersonrafaelnonnemacher.repository;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AtorRepository extends CrudRepository<Ator, Integer> {

    Ator findByNome(String nome);

    Ator save(Ator ator);

    void delete(Ator ator);

    Ator update(Ator ator);

    List<Ator> findAll();
}
