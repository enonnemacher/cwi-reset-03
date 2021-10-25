package br.com.cwi.reset.edersonrafaelnonnemacher.controller;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Diretor;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.AtorRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.DiretorRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.response.AtorEmAtividade;
import br.com.cwi.reset.edersonrafaelnonnemacher.service.AtorService;
import br.com.cwi.reset.edersonrafaelnonnemacher.service.DiretorService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    private DiretorService diretorService;

    public DiretorController() {
        this.diretorService = new DiretorService(FakeDatabase.getInstance());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        this.diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    public List<Diretor> listarDiretores(@RequestParam String filtroNome) throws Exception {
        return this.diretorService.listarDiretores(filtroNome);
    }

    @GetMapping("/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception {
        return this.diretorService.consultarDiretor(id);
    }
}
