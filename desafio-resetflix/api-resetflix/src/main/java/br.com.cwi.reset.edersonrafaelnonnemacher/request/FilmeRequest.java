package br.com.cwi.reset.edersonrafaelnonnemacher.request;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Genero;

import javax.validation.constraints.NotNull;
import java.util.List;

public class FilmeRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo anoLancamento.")
    private Integer anoLancamento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo capaFilme.")
    private String capaFilme;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo generos.")
    private List<Genero> generos;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo idDiretor.")
    private Integer idDiretor;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo idEstudio.")
    private Integer idEstudio;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo resumo.")
    private String resumo;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo personagens.")
    private List<PersonagemRequest> personagens;

    public FilmeRequest(String nome, Integer anoLancamento, String capaFilme, List<Genero> generos, Integer idDiretor, Integer idEstudio, String resumo, List<PersonagemRequest> personagens) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.capaFilme = capaFilme;
        this.generos = generos;
        this.idDiretor = idDiretor;
        this.idEstudio = idEstudio;
        this.resumo = resumo;
        this.personagens = personagens;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getCapaFilme() {
        return capaFilme;
    }

    public void setCapaFilme(String capaFilme) {
        this.capaFilme = capaFilme;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Integer getIdDiretor() {
        return idDiretor;
    }

    public void setIdDiretor(Integer idDiretor) {
        this.idDiretor = idDiretor;
    }

    public Integer getIdEstudio() {
        return idEstudio;
    }

    public void setIdEstudio(Integer idEstudio) {
        this.idEstudio = idEstudio;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public List<PersonagemRequest> getPersonagens() {
        return personagens;
    }

    public void setPersonagens(List<PersonagemRequest> personagens) {
        this.personagens = personagens;
    }
}
