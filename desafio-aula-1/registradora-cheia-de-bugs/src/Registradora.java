/* Bugs consertados:
 * alterado: paes para pao, sanduba para sanduiche
 * modificado quantidade de fatias da torta de 1 para 16 por torta
 * corrigido cálculo do pao e da torta na classe RelacaoPesoPreso, e também retirado acento do cafe
 * classe QuantidadeMinimaItem - return de cafe/leite estava invertido, e alterado sanduiche para <= 1
 * Classe itensPorQuantidade: adicionado construtor padrão, gets e sets, métodos estoque e verificaEstoque
 * Criada flag cozinha, para saber se a cozinha está aberta ou não, para assim poder ou não repor o item que o cliente deseja
 *
 * */

public class Registradora {

    public static void main(String[] args) {
        primeiroBug();

        segundoBug();

        terceiroBug();

        quartoBug();

        quintoBug();

        sextoBug();
    }

    private static double registrarItem(String item, int quantidade) {
        double precoItem = RelacaoPesoPreco.retornaPrecoProduto(item, quantidade);

        if (QuantidadeMinimaItem.precisaReposicao(item)) {
            if ("pao".equals(item) || "sanduiche".equals(item) || "torta".equals(item)) {
                if (!DataProjeto.cozinhaEmFuncionamento() && DataProjeto.getCozinha() == false) {
                    System.out.println("Cozinha fechada!");
                } else if (DataProjeto.getCozinha() == true) {
                    ReposicaoCozinha.reporItem(item);
                    //System.out.println("Cozinha aberta");
                }
            }

            if ("leite".equals(item) || "cafe".equals(item)) {
                ReposicaoFornecedor.reporItem(item);
            }
        }

        ItensPorQuantidade.estoque(item, quantidade);

        return precoItem;
    }

    private static void primeiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "sanduiche";
        int quantidade = 4;

        if (ItensPorQuantidade.verificaEstoque(item) <= 0 && DataProjeto.getCozinha() == false) {
            System.out.println("Reposição indisponível de " + item + ", quantidade restante em estoque é de " + ItensPorQuantidade.verificaEstoque(item));
        } else {
            double precoTotal = registrarItem(item, quantidade);
            System.out.println(String.format("Valor total: %.2f", precoTotal));
        }
    }

    private static void segundoBug() {
        DataProjeto.criarDataComCozinhaEncerradaMasComDiaUtil();
        String item = "torta";
        int quantidade = 10;

        if (ItensPorQuantidade.verificaEstoque(item) <= 0 && DataProjeto.getCozinha() == false) {
            System.out.println("Reposição indisponível de " + item + ", quantidade restante em estoque é de " + ItensPorQuantidade.verificaEstoque(item));
        } else {
            double precoTotal = registrarItem(item, quantidade);
            System.out.println(String.format("Valor total: %.2f", precoTotal));
        }
    }

    private static void terceiroBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "cafe";
        int quantidade = 40;

        if (ItensPorQuantidade.verificaEstoque(item) <= 0 && DataProjeto.getCozinha() == false) {
            System.out.println("Reposição indisponível de " + item + ", quantidade restante em estoque é de " + ItensPorQuantidade.verificaEstoque(item));
        } else {
            double precoTotal = registrarItem(item, quantidade);
            System.out.println(String.format("Valor total: %.2f", precoTotal));
        }
    }

    private static void quartoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        if (ItensPorQuantidade.verificaEstoque(item) <= 0 && DataProjeto.getCozinha() == false) {
            System.out.println("Reposição indisponível de " + item + ", quantidade restante em estoque é de " + ItensPorQuantidade.verificaEstoque(item));
        } else {
            double precoTotal = registrarItem(item, quantidade);
            System.out.println(String.format("Valor total: %.2f", precoTotal));
        }

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        if (ItensPorQuantidade.verificaEstoque(item2) <= 0 && DataProjeto.getCozinha() == false) {
            System.out.println("Reposição indisponível de " + item2 + ", quantidade restante em estoque é de " + ItensPorQuantidade.verificaEstoque(item2));
        } else {
            double precoTotal2 = registrarItem(item2, quantidade2);
            System.out.println(String.format("Valor total: %.2f", precoTotal2));
        }
    }

    private static void quintoBug() {
        DataProjeto.criarDataComCozinhaFuncionando();
        String item = "pao";
        int quantidade = 10;

        if (ItensPorQuantidade.verificaEstoque(item) <= 0 && DataProjeto.getCozinha() == false) {
            System.out.println("Reposição indisponível de " + item + ", quantidade restante em estoque é de " + ItensPorQuantidade.verificaEstoque(item));
        } else {
            double precoTotal = registrarItem(item, quantidade);
            System.out.println(String.format("Valor total: %.2f", precoTotal));
        }
    }

    private static void sextoBug() {
        DataProjeto.criarDataComCozinhaEncerradaSemDiaUtil();

        // Cliente 1
        String item = "sanduiche";
        int quantidade = 20;

        if (ItensPorQuantidade.verificaEstoque(item) <= 0 && DataProjeto.getCozinha() == false) {
            System.out.println("Reposição indisponível de " + item + ", quantidade restante em estoque é de " + ItensPorQuantidade.verificaEstoque(item));
        } else {
            double precoTotal = registrarItem(item, quantidade);
            System.out.println(String.format("Valor total: %.2f", precoTotal));
        }

        // Cliente 2
        String item2 = "sanduiche";
        int quantidade2 = 5;

        if (ItensPorQuantidade.verificaEstoque(item2) <= 0 && DataProjeto.getCozinha() == false) {
            System.out.println("Reposição indisponível de " + item2 + ", quantidade restante em estoque é 0");
        } else {
            double precoTotal2 = registrarItem(item2, quantidade2);
            System.out.println(String.format("Valor total: %.2f", precoTotal2));
        }

    }
}
