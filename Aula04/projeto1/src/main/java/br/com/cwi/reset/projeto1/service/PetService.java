package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;

import java.util.List;

public class PetService {

    private PetRepository repository = new PetRepository();

    public Pet cadastrarPet(Pet pet) throws PetJaExistenteException {
        Pet petJaExistente = repository.buscarPetPeloNome(pet.getNome());

        if (petJaExistente != null) {
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " já existe");
        }
        repository.save(pet);
        return pet;
    }

    public List<Pet> getPet() {
        return repository.findAll();
    }

    public Pet buscarPetPeloNome(String nome) {
        return repository.buscarPetPeloNome(nome);
    }

    public void deletarPet(String nomePet) throws PetNaoExistenteException {
        Pet pet = buscarPetPeloNome(nomePet);
        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nomePet + " não existe");
        }
        repository.delete(pet);
    }

    public Pet atualizarPet(Pet pet) throws PetNaoExistenteException {
        Pet petJaCadastrado = buscarPetPeloNome(pet.getNome());
        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + pet.getNome() + " não existe");
        }
        return repository.update(pet);
    }
}
