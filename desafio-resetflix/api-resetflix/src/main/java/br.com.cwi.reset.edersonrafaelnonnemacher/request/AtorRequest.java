package br.com.cwi.reset.edersonrafaelnonnemacher.request;

/* AtorRequest é a classe que você vai usar como entrada pra criar um ator. Percebeu que "Ator" tem um atributo a mais que "AtorRequest"?
Há situações nas quais quem está usando o programa não vai inserir manualmente todas as características que aquele objeto realmente tem.
Neste caso, por exemplo, um ID pode ser atribuído automaticamente em vez de ser um campo pro qual você tem que definir um valor ao criar um ator. */

import br.com.cwi.reset.edersonrafaelnonnemacher.model.StatusCarreira;

import java.time.LocalDate;

public class AtorRequest {

    private String nome;
    private LocalDate dataNascimento;
    private StatusCarreira statusCarreira;
    private Integer anoInicioAtividade;

    public AtorRequest(String nome, LocalDate dataNascimento, StatusCarreira statusCarreira, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.statusCarreira = statusCarreira;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public StatusCarreira getStatusCarreira() {
        return statusCarreira;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }
}
