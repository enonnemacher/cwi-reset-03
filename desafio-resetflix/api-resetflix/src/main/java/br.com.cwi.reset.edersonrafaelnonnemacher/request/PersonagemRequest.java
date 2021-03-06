package br.com.cwi.reset.edersonrafaelnonnemacher.request;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.TipoAtuacao;

import javax.validation.constraints.NotNull;

public class PersonagemRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo idAtor.")
    private Integer idAtor;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nomePersonagem.")
    private String nomePersonagem;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo descricaoPersonagem.")
    private String descricaoPersonagem;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo tipoAtuacao.")
    private TipoAtuacao tipoAtuacao;

    public PersonagemRequest(Integer idAtor, String nomePersonagem, String descricaoPersonagem, TipoAtuacao tipoAtuacao) {
        this.idAtor = idAtor;
        this.nomePersonagem = nomePersonagem;
        this.descricaoPersonagem = descricaoPersonagem;
        this.tipoAtuacao = tipoAtuacao;
    }

    public Integer getIdAtor() {
        return idAtor;
    }

    public void setIdAtor(Integer idAtor) {
        this.idAtor = idAtor;
    }

    public String getNomePersonagem() {
        return nomePersonagem;
    }

    public void setNomePersonagem(String nomePersonagem) {
        this.nomePersonagem = nomePersonagem;
    }

    public String getDescricaoPersonagem() {
        return descricaoPersonagem;
    }

    public void setDescricaoPersonagem(String descricaoPersonagem) {
        this.descricaoPersonagem = descricaoPersonagem;
    }

    public TipoAtuacao getTipoAtuacao() {
        return tipoAtuacao;
    }

    public void setTipoAtuacao(TipoAtuacao tipoAtuacao) {
        this.tipoAtuacao = tipoAtuacao;
    }
}
