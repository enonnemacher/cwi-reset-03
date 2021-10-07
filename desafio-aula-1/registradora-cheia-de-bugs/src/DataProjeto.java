import java.util.Random;

/**
 * Esta classe foi criada com o intuito de facilitar a verificação do horário de funcionamento de forma didática
 */
public class DataProjeto {

    // verifica se a cozinha está aberta ou não
    public static boolean cozinha;

    private static boolean diaUtil;
    private static int hora;
    private static int minuto;

    public static DataProjeto criarDataComCozinhaFuncionando() {
        cozinha = true;
        Random random = new Random();
        int hora = random.nextInt(10) + 6;
        int minuto = hora == 16 ? random.nextInt(40) : random.nextInt(60);

        return new DataProjeto(true, hora, minuto);
    }

    public static DataProjeto criarDataComCozinhaEncerradaMasComDiaUtil() {
        cozinha = false;
        Random random = new Random();
        int hora = random.nextInt(6);
        int minuto = random.nextInt(60);

        return new DataProjeto(true, hora, minuto);
    }

    public static DataProjeto criarDataComCozinhaEncerradaSemDiaUtil() {
        cozinha = false;
        Random random = new Random();
        int hora = random.nextInt(24);
        int minuto = random.nextInt(60);

        return new DataProjeto(false, hora, minuto);
    }

    private DataProjeto(boolean diaUtil, int hora, int minuto) {
        this.diaUtil = diaUtil;
        this.hora = hora;
        this.minuto = minuto;
    }

    public DataProjeto(boolean cozinha){
        cozinha = true;
    }

    public static boolean cozinhaEmFuncionamento() {
        cozinha = true;
        boolean isHorarioFuncionamento = hora > 6 && hora <= 16;
        boolean isMinutoFuncionamento = hora == 16 ? minuto <= 40 : minuto < 60;

        return diaUtil && isHorarioFuncionamento && isMinutoFuncionamento;
    }

    public static boolean getCozinha() {
        return cozinha;
    }

    /*public static void setCozinha(boolean cozinha) {
        DataProjeto.cozinha = cozinha;
    }*/
}
