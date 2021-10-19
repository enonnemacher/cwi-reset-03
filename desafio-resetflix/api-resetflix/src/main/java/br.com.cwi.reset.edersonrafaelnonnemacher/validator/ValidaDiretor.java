package br.com.cwi.reset.edersonrafaelnonnemacher.validator;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.MesmoNomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.anoAtividadeMaiorNascimentoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.dataNascimentoMaiorException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.diretorSemSobrenomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Diretor;

import java.time.LocalDate;

public class ValidaDiretor {

    public void accept(final String nome, final LocalDate dataNascimento, final Integer anoInicioAtividade, final TipoDominioException tipoDominioException) throws Exception {

        if (nome.isEmpty()) {
            throw new CampoObrigatorioException("nome.");
        }
        if (dataNascimento == null) {
            throw new CampoObrigatorioException("data de nascimento.");
        }
        if (anoInicioAtividade == null) {
            throw new CampoObrigatorioException("ano do início de atividade.");
        }

        if (nome.split("").length < 2) {
            throw new diretorSemSobrenomeException(tipoDominioException.getSingular());
        }

        if (LocalDate.now().isBefore(dataNascimento)) {
            throw new dataNascimentoMaiorException(tipoDominioException.getPlural());
        }

        if (anoInicioAtividade <= dataNascimento.getYear()) {
            throw new anoAtividadeMaiorNascimentoException(tipoDominioException.getSingular());
        }

        for (Diretor listaDeDiretores : FakeDatabase.getInstance().recuperaDiretores()) {
            if (listaDeDiretores.getNome().equalsIgnoreCase(nome)) {
                throw new MesmoNomeException(nome);
            }
        }
    }
}