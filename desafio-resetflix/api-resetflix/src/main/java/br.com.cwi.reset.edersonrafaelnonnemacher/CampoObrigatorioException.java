package br.com.cwi.reset.edersonrafaelnonnemacher;

public class CampoObrigatorioException extends Exception {

    public CampoObrigatorioException(){
        // *** verificar campo a informar ***
        super("Campo obrigatório não informado. Favor informar o campo");
    }
}
