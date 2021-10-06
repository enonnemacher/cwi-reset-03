public class RelacaoPesoPreco {

    public static double retornaPrecoProduto(String item, int qtd) {
        double precoTotal = 0;

        if ("pao".equals(item)) {
            precoTotal = ((qtd * 60) * 12.75) / 1000;
            //precoTotal = 12.75 * (qtd * 60 / 1000);
        }

        if ("torta".equals(item)) {
            precoTotal = (qtd * 96.00) / 16;
            //precoTotal = 96.00 * (qtd / 16);
        }

        if ("leite".equals(item)) {
            precoTotal = 4.48 * qtd;
        }

        if ("cafe".equals(item)) {
            precoTotal = 9.56 * qtd;
        }

        if ("sanduiche".equals(item)) {
            precoTotal = 4.5 * qtd;
        }

        return precoTotal;
    }
}
