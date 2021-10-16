package br.com.cwi.reset.primeiroprojetospring.controller;

import br.com.cwi.reset.primeiroprojetospring.domain.AvaliacaoForaDoPadraoException;
import br.com.cwi.reset.primeiroprojetospring.domain.Diretor;
import br.com.cwi.reset.primeiroprojetospring.domain.Filme;
import br.com.cwi.reset.primeiroprojetospring.domain.Genero;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @GetMapping
    public List<Filme> getFilme() throws AvaliacaoForaDoPadraoException {

        LocalDate dataNascimento = LocalDate.of(1960, 8, 05);
        Diretor diretor = new Diretor("Christopher Nolan", dataNascimento, 50, Genero.MASCULINO);
        return Arrays.asList(new Filme("Interestelar", "Filme muito bom", 120, 2014, 5.0, diretor));
    }

}
