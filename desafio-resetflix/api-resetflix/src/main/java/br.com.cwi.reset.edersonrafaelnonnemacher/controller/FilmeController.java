package br.com.cwi.reset.edersonrafaelnonnemacher.controller;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Filme;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.FilmeRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.service.FilmeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    private FilmeService filmeService;

    public FilmeController() {
        this.filmeService = new FilmeService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarFilme(@RequestBody FilmeRequest filmeRequest) throws Exception {

        this.filmeService.criarFilme(filmeRequest);
    }

    @GetMapping
    public List<Filme> consultarFilmes(@RequestParam String nomeFilme, @RequestParam String nomeDiretor,
                                       @RequestParam String nomePersonagem, @RequestParam String nomeAtor) throws Exception {

        return this.filmeService.consultarFilmes(nomeFilme, nomeDiretor, nomePersonagem, nomeAtor);
    }
}
