import java.util.Random;

public class ReposicaoFornecedor {

    static void reporItem(String item) {
        Random random = new Random();

        if ("leite".equals(item)) {
            ItensPorQuantidade.leite = random.nextInt(40) + 10;
        }

        if ("cafe".equals(item)) {
            ItensPorQuantidade.cafe = random.nextInt(40) + 10;
        }
    }
}
