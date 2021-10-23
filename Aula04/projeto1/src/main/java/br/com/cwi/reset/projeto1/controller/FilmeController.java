package br.com.cwi.reset.projeto1.controller;

import br.com.cwi.reset.projeto1.domain.Filme;
import br.com.cwi.reset.projeto1.exception.FilmeJaExistenteException;
import br.com.cwi.reset.projeto1.exception.FilmeNaoExistenteException;
import br.com.cwi.reset.projeto1.service.FilmeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {
    

    private FilmeService filmeService = new FilmeService();

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
        try {
            Filme filmeSalvo = filmeService.salvar(filme);
            return ResponseEntity.ok(filmeSalvo);
        } catch (FilmeJaExistenteException ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public List<Filme> consultarTodos() {
        return filmeService.listarTodos();
    }

    @GetMapping("/{nome}")
    public Filme buscarFilmePeloNome(@PathVariable String nome) {
        return filmeService.buscarPorNome(nome);
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity deletarFilme(@PathVariable String nome) {
        try {
            filmeService.deletar(nome);
            return ResponseEntity.ok().build();
        } catch (FilmeNaoExistenteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping
    public ResponseEntity<Filme> atualizarFilme(@RequestBody Filme filme) {
        try {
            return ResponseEntity.ok(filmeService.atualizar(filme));
        } catch (FilmeNaoExistenteException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
