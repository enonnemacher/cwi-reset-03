package br.com.cwi.reset.edersonrafaelnonnemacher.request;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class DiretorRequest {

    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo nome.")
    private String nome;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo dataNascimento.")
    private LocalDate dataNascimento;
    @NotNull(message = "Campo obrigatório não informado. Favor informar o campo anoInicioAtividade.")
    private Integer anoInicioAtividade;

    public DiretorRequest(String nome, LocalDate dataNascimento, Integer anoInicioAtividade) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.anoInicioAtividade = anoInicioAtividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getAnoInicioAtividade() {
        return anoInicioAtividade;
    }

    public void setAnoInicioAtividade(Integer anoInicioAtividade) {
        this.anoInicioAtividade = anoInicioAtividade;
    }
}
