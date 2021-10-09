package main;

public class Filme {

    private String nome;
    private String descricao;
    private double duracao;
    private int anoLancamento;
    private int avaliacao;

    private String nomeDiretor;
    private int idadeDiretor;
    private int quantidadeFilmes;

    public Filme(String nome, String descricao, double duracao, int anoLancamento, int avaliacao, String nomeDiretor, int idadeDiretor, int quantidadeFilmes) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.nomeDiretor = nomeDiretor;
        this.idadeDiretor = idadeDiretor;
        this.quantidadeFilmes = quantidadeFilmes;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome = '" + nome + '\'' +
                ", descricao = '" + descricao + '\'' +
                ", duracao = " + duracao +
                " minutos, nomeDiretor = '" + nomeDiretor + '\'' +
                '}';
    }
}

