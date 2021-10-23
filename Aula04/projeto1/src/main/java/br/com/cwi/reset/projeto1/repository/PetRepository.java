package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Pet;

import java.util.List;

public interface PetRepository {

    Pet buscarPetPeloNome(String nome);

    Pet save(Pet pet);

    void delete(Pet pet);

    Pet update(Pet pet);

    List<Pet> listarTodos();
}
