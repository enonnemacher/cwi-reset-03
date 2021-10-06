public class ReposicaoCozinha {

    static void reporItem(String item) {
        if ("paes".equals(item)) {
            ItensPorQuantidade.pao = 3600;
        }
        if ("torta".equals(item)) {
            //ItensPorQuantidade.torta = 4; * 16 fatias/torta
            ItensPorQuantidade.torta = 64;
        }
        if ("sanduiche".equals(item)) {
            ItensPorQuantidade.sanduiche = 20;
        }
    }
}
