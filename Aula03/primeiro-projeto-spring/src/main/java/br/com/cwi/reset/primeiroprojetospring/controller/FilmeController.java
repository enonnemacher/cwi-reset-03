package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    List<Filme> filmes = new ArrayList<>();

    /*@GetMapping
    public List<Filme> getFilme() throws AvaliacaoForaDoPadraoException {

        LocalDate dataNascimento = LocalDate.of(1960, 8, 05);
        Diretor diretor = new Diretor("Christopher Nolan", dataNascimento, 50, Genero.MASCULINO);
        return Arrays.asList(new Filme("Interestelar", "Filme muito bom", 120, 2014, 5.0, diretor));
    }*/

    @PostMapping
    public ResponseEntity<Filme> cadastrarFilme(@RequestBody Filme filme) {
        Filme filmeCadastrado = buscarFilmePeloNome(filme.getNome());
        if (filmeCadastrado != null) {
            return ResponseEntity.notFound().build(); // return 404
        }
        filmes.add(filme);
        return ResponseEntity.ok(filme); // se não, cadastra o filme
    }

    @GetMapping
    public List<Filme> getFilmes() {
        return filmes;
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Filme> getFilmeNome(@PathVariable String nome) {
        Filme filme = buscarFilmePeloNome(nome);

        if (filme == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(filme);
    }

    @DeleteMapping("/{nome}")
    public void deletarFilme(@PathVariable String nome) {
        Filme filme = buscarFilmePeloNome(nome);
        if (filme != null) {
            filmes.remove(filme);
        }
    }

    @PutMapping
    public void atualizarFilme(@RequestBody Filme filme) {
        Filme filmeCadastrado = buscarFilmePeloNome(filme.getNome());

        if (filmeCadastrado != null) {
            filmes.remove(filmeCadastrado);
            filmes.add(filme);
        }
    }

    private Filme buscarFilmePeloNome(String nome) {
        for (Filme filme : filmes) {
            if (filme.getNome().equals(nome)) {
                return filme;
            }
        }
        return null;
    }
}
