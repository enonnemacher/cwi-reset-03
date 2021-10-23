package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pet")
public class PetController {

    private static List<Pet> pets = new ArrayList<>();

    @GetMapping
    public List<Pet> getPet() {
        return pets;
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Pet> getById(@PathVariable String nome) {
        Pet pet = buscarPetPeloNome(nome);

        if (pet == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pet);
    }

    private Pet buscarPetPeloNome(String nome) {
        for (Pet pet : pets) {
            if (pet.getNome().equals(nome)) {
                return pet;
            }
        }
        return null;
    }

    @PostMapping
    public Pet cadastrarPet(@RequestBody Pet pet) {
        pets.add(pet);
        return pet;
    }

    @PutMapping
    public void atualizarPet(@RequestBody Pet pet) {
        Pet petCadastrado = buscarPetPeloNome(pet.getNome());

        if (petCadastrado != null) {
            pets.remove(petCadastrado);
            pets.add(pet);
        }
    }

    @DeleteMapping("/{nome}")
    public void deletarPet(@PathVariable String nome) {
        Pet pet = buscarPetPeloNome(nome);
        if (pet != null) {
            pets.remove(pet);
        }
    }

}
