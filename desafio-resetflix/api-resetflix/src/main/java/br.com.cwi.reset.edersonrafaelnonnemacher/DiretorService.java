package br.com.cwi.reset.edersonrafaelnonnemacher;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DiretorService {

    private FakeDatabase fakeDatabase;

    public static Integer id = 1;

    public DiretorService(FakeDatabase fakeDatabase) {
        this.fakeDatabase = fakeDatabase;
    }

    // 1.1 Cadastrar diretor
    public void cadastrarDiretor(DiretorRequest diretorRequest) throws CampoObrigatorioException, MesmoNomeException, ParseException, diretorSemSobrenomeException, dataNascimentoMaiorDiretorException, anoAtividadeMaiorNascimentoDiretorException {

        if (diretorRequest.getNome().isEmpty()) {
            throw new CampoObrigatorioException("nome.");
        }
        if (diretorRequest.getDataNascimento() == null) {
            throw new CampoObrigatorioException("data de nascimento.");
        }
        if (diretorRequest.getAnoInicioAtividade() == null) {
            throw new CampoObrigatorioException("ano do início de atividade.");
        }

        String nomeDiretor[] = diretorRequest.getNome().split("\\S+");
        if (nomeDiretor.length < 2) {
            throw new diretorSemSobrenomeException(diretorRequest.getNome());
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dataNascimento = dateFormat.parse(diretorRequest.getDataNascimento().toString());
        Date dataHoje = dateFormat.parse(LocalDate.now().toString());
        if (dataNascimento.after(dataHoje)) {
            throw new dataNascimentoMaiorDiretorException();
        }

        if (diretorRequest.getDataNascimento().getYear() - diretorRequest.getAnoInicioAtividade() >= 0) {
            throw new anoAtividadeMaiorNascimentoDiretorException();
        }

        for (Diretor listaDeDiretores : fakeDatabase.recuperaDiretores()) {
            if (listaDeDiretores.getNome().equals(listaDeDiretores.getNome())) {
                throw new MesmoNomeException(listaDeDiretores.getNome());
            }
        }

        this.fakeDatabase.persisteDiretor(new Diretor(id++, diretorRequest.getNome(),
                diretorRequest.getDataNascimento(), diretorRequest.getAnoInicioAtividade()));
    }

    // 1.2 - listar diretores - filtrar por nome
    public List listarDiretores(String filtroNome) throws ListaDiretoresVazioException, DiretorNaoEncontradoComFiltro {

        List<Diretor> buscaDiretores = new ArrayList<>();
        List<Diretor> listaDiretores = fakeDatabase.recuperaDiretores();

        if (listaDiretores.isEmpty()) {
            throw new ListaDiretoresVazioException();
        } else {
            for (Diretor diretor : listaDiretores) {
                if (diretor.getNome().contains(filtroNome)) {
                    buscaDiretores.add(diretor);
                }
                if (buscaDiretores.isEmpty()) {
                    throw new DiretorNaoEncontradoComFiltro(filtroNome);
                }
            }
        }
        return buscaDiretores;
    }

    // 1.3 - Consultar diretor id
    public List consultarDiretor(Integer id) throws CampoObrigatorioException, idDiretorException {

        if (id == null) {
            throw new CampoObrigatorioException("id.");
        }

        Diretor buscaDiretor = null;
        List<Diretor> listaDiretores = fakeDatabase.recuperaDiretores();

        for (Diretor diretor : listaDiretores) {
            if (diretor.getId().equals(id)) {
                buscaDiretor = diretor;
            } else {
                throw new idDiretorException(id);
            }
        }
        return Arrays.asList(buscaDiretor);
    }
}
