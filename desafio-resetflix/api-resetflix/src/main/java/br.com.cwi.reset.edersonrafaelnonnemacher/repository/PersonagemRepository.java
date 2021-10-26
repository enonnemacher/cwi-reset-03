package br.com.cwi.reset.edersonrafaelnonnemacher.repository;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonagemRepository extends CrudRepository<PersonagemAtor, Integer> {
    List<PersonagemAtor> findAll();
}

