package br.com.cwi.reset.edersonrafaelnonnemacher.controller;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Estudio;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.AtorRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.EstudioRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.response.AtorEmAtividade;
import br.com.cwi.reset.edersonrafaelnonnemacher.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        this.estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    public List<Estudio> consultarEstudios(@RequestParam String filtroNome) throws Exception {
        return this.estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping("/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception {
        return this.estudioService.consultarEstudio(id);
    }
}
