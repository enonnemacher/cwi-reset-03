package br.com.cwi.reset.edersonrafaelnonnemacher.controller;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Diretor;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.DiretorRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.service.DiretorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/diretores")
public class DiretorController {

    @Autowired
    private DiretorService diretorService;

    @Valid
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void cadastrarDiretor(@RequestBody DiretorRequest diretorRequest) throws Exception {
        diretorService.cadastrarDiretor(diretorRequest);
    }

    @GetMapping
    public List<Diretor> listarDiretores(@RequestParam String filtroNome) throws Exception {
        return diretorService.listarDiretores(filtroNome);
    }

    @GetMapping(path = "/{id}")
    public Diretor consultarDiretor(@PathVariable Integer id) throws Exception {
        return diretorService.consultarDiretor(id);
    }

    @Valid
    @PutMapping("/{id}")
    public void atualizarDiretor(@PathVariable Integer id, @RequestBody DiretorRequest diretorRequest) throws Exception {
        diretorService.atualizarDiretor(id, diretorRequest);
    }

    @DeleteMapping("/{id}")
    public void removerDiretores(@PathVariable Integer id) throws Exception {
        diretorService.removerDiretores(id);
    }
}
