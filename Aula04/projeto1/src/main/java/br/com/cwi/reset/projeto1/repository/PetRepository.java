package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {

    Pet findByNome(String nome);

    Pet save(Pet pet);

    void delete(Pet pet);

    Pet update(Pet pet);

    List<Pet> findAll();
}
