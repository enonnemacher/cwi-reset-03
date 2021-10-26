package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Ator;
import br.com.cwi.reset.projeto1.exception.AtorJaExistenteException;
import br.com.cwi.reset.projeto1.exception.AtorNaoExistenteException;
import br.com.cwi.reset.projeto1.exception.PetNaoExistenteException;
import br.com.cwi.reset.projeto1.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public class AtorController {

    @Autowired
    private AtorService atorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ator cadastrarAtor(@RequestBody Ator ator) throws AtorJaExistenteException {
        return atorService.cadastrarAtor(ator);
    }

    @GetMapping("/{nome}")
    public Ator buscarAtorPorNome(@PathVariable String nome) throws AtorNaoExistenteException {
        return atorService.buscarAtorPeloNome(nome);
    }

    @DeleteMapping("/{id}")
    public void deletarAtor(@PathVariable Integer id) throws AtorNaoExistenteException {
        atorService.deletarAtor(id);
    }

    // Feitos: Criar, buscar por nome, deletar pelo id
    // Falta: procurar por oscar, e outro filtro do desafio

}
