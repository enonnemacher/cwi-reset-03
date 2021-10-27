package br.com.cwi.reset.edersonrafaelnonnemacher.exception;

public class DiretorVinculadoFilmeException extends Exception {

    public DiretorVinculadoFilmeException(String campo){
        super(String.format("Este %s está vinculado a um ou mais filmes, para remover o %s é necessário" +
                "remover os seus filmes de participação.", campo));
    }
}
