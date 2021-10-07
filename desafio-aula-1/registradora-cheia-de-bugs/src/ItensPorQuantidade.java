public class ItensPorQuantidade {

    static int pao = 3600;
    //static int torta = 4; * 16 fatias/torta
    static int torta = 64;
    static int sanduiche = 20;
    static int leite = 20;
    static int cafe = 20;

    public ItensPorQuantidade() {
        setPao(3600);
        setTorta(64);
        setSanduiche(20);
        setLeite(20);
        setCafe(20);
    }

    public static int getPao() {
        return pao;
    }

    public static void setPao(int pao) {
        ItensPorQuantidade.pao += pao;
    }

    public static int getTorta() {
        return torta;
    }

    public static void setTorta(int torta) {
        ItensPorQuantidade.torta += torta;
    }

    public static int getSanduiche() {
        return sanduiche;
    }

    public static void setSanduiche(int sanduiche) {
        ItensPorQuantidade.sanduiche += sanduiche;
    }

    public static int getLeite() {
        return leite;
    }

    public static void setLeite(int leite) {
        ItensPorQuantidade.leite += leite;
    }

    public static int getCafe() {
        return cafe;
    }

    public static void setCafe(int cafe) {
        ItensPorQuantidade.cafe += cafe;
    }

    public static void estoque(String produto, int quantidade) {
        if ("pao".equals(produto)) {
            //this.pao -= quantidade;
            pao -= quantidade;
        }
        if ("torta".equals(produto)) {
            //this.torta -= quantidade;
            torta -= quantidade;
        }
        if ("sanduiche".equals(produto)) {
            //this.sanduiche -= quantidade;
            sanduiche -= quantidade;
        }
        if ("cafe".equals(produto)) {
            //this.cafe -= quantidade;
            cafe -= quantidade;
        }
        if ("leite".equals(produto)) {
            //this.leite -= quantidade;
            leite -= quantidade;
        }
    }

    public static int verificaEstoque(String produto) {
        if ("pao".equals(produto)) {
            return getPao();
        }
        if ("torta".equals(produto)) {
            return getTorta();
        }
        if ("sanduiche".equals(produto)) {
            return getSanduiche();
        }
        if ("cafe".equals(produto)) {
            return getCafe();
        }
        if ("leite".equals(produto)) {
            return getLeite();
        }
        return 0;
    }
}
