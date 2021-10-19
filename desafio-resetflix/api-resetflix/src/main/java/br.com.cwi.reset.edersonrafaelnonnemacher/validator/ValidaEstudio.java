package br.com.cwi.reset.edersonrafaelnonnemacher.validator;

import br.com.cwi.reset.edersonrafaelnonnemacher.FakeDatabase;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.MesmoNomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.dataCriacaoMaiorDataAtualException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Estudio;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.StatusAtividade;

import java.time.LocalDate;

public class ValidaEstudio {

    public void accept(final String nome, final String descricao, final LocalDate dataCriacao, final StatusAtividade statusAtividade, final TipoDominioException tipoDominioException) throws Exception {
        if (nome.isEmpty()) {
            throw new CampoObrigatorioException("nome.");
        }

        if (descricao.isEmpty()) {
            throw new CampoObrigatorioException("descricao.");
        }

        if (dataCriacao == null) {
            throw new CampoObrigatorioException("dataCriacao.");
        }

        if (statusAtividade == null) {
            throw new CampoObrigatorioException("statusAtividade.");
        }

        for (Estudio listaEstudios : FakeDatabase.getInstance().recuperaEstudios()) {
            if (listaEstudios.getNome().equalsIgnoreCase(nome)) {
                throw new MesmoNomeException(nome);
            }
        }

        if (LocalDate.now().isBefore(dataCriacao)) {
            throw new dataCriacaoMaiorDataAtualException(tipoDominioException.getPlural());
        }
    }
}
