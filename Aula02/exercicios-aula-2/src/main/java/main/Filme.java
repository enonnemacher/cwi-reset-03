package main;

public class Filme {

    private String nome;
    private String descricao;
    private double duracao;
    private int anoLancamento;
    private int avaliacao;
    private Pessoa pessoa;

    public Filme(String nome, String descricao, double duracao, int anoLancamento, int avaliacao, Pessoa pessoa) {
        this.nome = nome;
        this.descricao = descricao;
        this.duracao = duracao;
        this.anoLancamento = anoLancamento;
        this.avaliacao = avaliacao;
        this.pessoa = pessoa;
    }

    public void validaAvaliacao() throws AvaliacaoForaDoPadraoException{
        if(avaliacao < 1 || avaliacao > 5){
            throw new AvaliacaoForaDoPadraoException();
        }
    }

    public void reproduzir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Duração: " + this.duracao);
        System.out.println("Nome diretor: " + pessoa.getNome());
    }
}

