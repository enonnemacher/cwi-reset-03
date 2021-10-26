package br.com.cwi.reset.edersonrafaelnonnemacher.repository;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.PersonagemAtor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonagemRepository extends CrudRepository<PersonagemAtor, Integer> {

    PersonagemAtor findByNome(String nome);

    PersonagemAtor save(PersonagemAtor personagemAtor);

    List<PersonagemAtor> findAll();
}

