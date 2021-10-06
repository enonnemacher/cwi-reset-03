import java.util.Random;

/**
 * Esta classe foi criada com o intuito de facilitar a verificação do horário de funcionamento de forma didática
 */
public class DataProjeto {

    private static boolean diaUtil;
    private static int hora;
    private static int minuto;

    public static DataProjeto criarDataComCozinhaFuncionando() {
        Random random = new Random();
        int hora = random.nextInt(10) + 6;
        int minuto = hora == 16 ? random.nextInt(40) : random.nextInt(60);

        return new DataProjeto(true, hora, minuto);
    }

    public static DataProjeto criarDataComCozinhaEncerradaMasComDiaUtil() {
        Random random = new Random();
        int hora = random.nextInt(6);
        int minuto = random.nextInt(60);

        return new DataProjeto(true, hora, minuto);
    }

    public static DataProjeto criarDataComCozinhaEncerradaSemDiaUtil() {
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

    public static boolean cozinhaEmFuncionamento() {
        boolean isHorarioFuncionamento = hora > 6 && hora <= 16;
        boolean isMinutoFuncionamento = hora == 16 ? minuto <= 40 : minuto < 60;

        return diaUtil && isHorarioFuncionamento && isMinutoFuncionamento;
    }
}
