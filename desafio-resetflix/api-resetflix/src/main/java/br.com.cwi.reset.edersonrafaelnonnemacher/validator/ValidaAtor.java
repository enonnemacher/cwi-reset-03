package br.com.cwi.reset.edersonrafaelnonnemacher.validator;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.MesmoNomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.anoAtividadeMaiorNascimentoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.atorSemSobrenomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.dataNascimentoMaiorException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.StatusCarreira;

import java.time.LocalDate;

public class ValidaAtor {

    public void accept(final String nome, final LocalDate dataNascimento, final Integer anoInicioAtividade, final StatusCarreira statusCarreira, final TipoDominioException tipoDominioException) throws Exception {
        if (nome.isEmpty()) {
            throw new CampoObrigatorioException("nome.");
        }

        if (dataNascimento == null) {
            throw new CampoObrigatorioException("data de nascimento.");
        }

        if (anoInicioAtividade == null) {
            throw new CampoObrigatorioException("ano do início de atividade.");
        }

        if (statusCarreira == null) {
            throw new CampoObrigatorioException("status da carreira.");
        }

        if (nome.split("").length < 2) {
            throw new atorSemSobrenomeException(tipoDominioException.getSingular());
        }

        if (LocalDate.now().isBefore(dataNascimento)) {
            throw new dataNascimentoMaiorException(tipoDominioException.getPlural());
        }

        if (anoInicioAtividade <= dataNascimento.getYear()) {
            throw new anoAtividadeMaiorNascimentoException(tipoDominioException.getSingular());
        }

        for (Ator listaDeAtores : FakeDatabase.getInstance().recuperaAtores()) {
            if (listaDeAtores.getNome().equalsIgnoreCase(nome)) {
                throw new MesmoNomeException(nome);
            }
        }
    }
}
