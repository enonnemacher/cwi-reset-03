package br.com.cwi.reset.projeto1.service;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {

    @Autowired
    private PetRepository repository;

    public Pet cadastrarPet(Pet pet) throws PetJaExistenteException {
        Pet petJaExistente = repository.findByNome(pet.getNome());

        if (petJaExistente != null) {
            throw new PetJaExistenteException("Pet com o nome " + pet.getNome() + " já existe");
        }
        repository.save(pet);
        return pet;
    }

    public List<Pet> listarTodos() {
        return repository.findAll();
    }

    public Pet buscarPetPeloNome(String nome) throws PetNaoExistenteException {
        Pet pet = repository.findByNome(nome);

        if (pet == null) {
            throw new PetNaoExistenteException("Pet com o nome " + nome + " não existe");
        }

        return pet;
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
