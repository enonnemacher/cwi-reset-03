package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import br.com.cwi.reset.projeto1.exception.PetJaExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private PetService petService = new PetService();

    @GetMapping
    public List<Pet> listarTodos() {
        return petService.listarTodos();
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Pet> buscarPetPorNome(@PathVariable String nome) {
        Pet pet = buscarPetPeloNome(nome);

        if (pet == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pet);
    }

    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) throws PetJaExistenteException {
        petService.cadastrarPet(pet);
        return pet;
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet) throws PetNaoExistenteException, PetJaExistenteException {
        Pet petCadastrado = buscarPetPeloNome(pet.getNome());

        if (petCadastrado != null) {
            petService.deletarPet(pet.getNome());
            petService.cadastrarPet(pet);
        }
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) throws PetNaoExistenteException {
        Pet pet = buscarPetPeloNome(nome);
        if (pet != null) {
            petService.deletarPet(pet.getNome());
        }
    }

    private Pet buscarPetPeloNome(String nome) {
        for (Pet pet : petService.listarTodos()) {
            if (pet.getNome().equals(nome)) {
                return pet;
            }
        }
        return null;
    }
}
