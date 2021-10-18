package br.com.cwi.reset.edersonrafaelnonnemacher.model;

import java.time.LocalDate;

public class Estudio {

    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate dataCriacao;
    StatusAtividade statusAtividade;

    public Estudio(Integer id, String nome, String descricao, LocalDate dataCriacao, StatusAtividade statusAtividade) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCriacao = dataCriacao;
        this.statusAtividade = statusAtividade;
    }
}
