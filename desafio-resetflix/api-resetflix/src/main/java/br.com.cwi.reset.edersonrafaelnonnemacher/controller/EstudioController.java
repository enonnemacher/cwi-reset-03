package br.com.cwi.reset.edersonrafaelnonnemacher.controller;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Estudio;
import br.com.cwi.reset.edersonrafaelnonnemacher.request.EstudioRequest;
import br.com.cwi.reset.edersonrafaelnonnemacher.service.EstudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/estudios")
public class EstudioController {

    @Autowired
    private EstudioService estudioService;

    @Valid
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarEstudio(@RequestBody EstudioRequest estudioRequest) throws Exception {
        estudioService.criarEstudio(estudioRequest);
    }

    @GetMapping
    public List<Estudio> consultarEstudios(@RequestParam String filtroNome) throws Exception {
        return estudioService.consultarEstudios(filtroNome);
    }

    @GetMapping(path = "/{id}")
    public Estudio consultarEstudio(@PathVariable Integer id) throws Exception {
        return estudioService.consultarEstudio(id);
    }
}
