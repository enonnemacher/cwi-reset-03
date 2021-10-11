package br.com.cwi.reset.edersonrafaelnonnemacher;

import java.time.LocalDate;
import java.util.List;

public class Filme {

    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private String capaFilme;
    List<Genero> generos;
    private Diretor diretor;
    List<PersonagemAtor> personagens;
    private String resumo;

    public Filme(Integer id, String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Diretor diretor, List<PersonagemAtor> personagens, String resumo) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.diretor = diretor;
        this.personagens = personagens;
        this.resumo = resumo;
    }
}
