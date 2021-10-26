package br.com.cwi.reset.edersonrafaelnonnemacher.controller;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.AtorRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.response.AtorEmAtividade;
import br.com.cwi.reset.edersonrafaelnonnemacher.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @Valid
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAtor(@RequestBody AtorRequest atorRequest) throws Exception {
        atorService.criarAtor(atorRequest);
    }

    @GetMapping("/em_atividade")
    public List<AtorEmAtividade> listarAtoresEmAtividade(@RequestParam String filtroNome) throws Exception {
        return atorService.listarAtoresEmAtividade(filtroNome);
    }

    @GetMapping("/{id}")
    public Ator consultarAtor(@PathVariable Integer id) throws Exception {
        return atorService.consultarAtor(id);
    }

    @GetMapping
    public List<Ator> consultarAtores() throws Exception {
        return atorService.consultarAtores();
    }
}