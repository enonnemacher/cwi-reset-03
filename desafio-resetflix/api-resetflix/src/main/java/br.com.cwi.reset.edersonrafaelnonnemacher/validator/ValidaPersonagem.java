package br.com.cwi.reset.edersonrafaelnonnemacher.validator;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.CampoObrigatorioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.TipoAtuacao;

public class ValidaPersonagem {

    public void accept(final Integer idAtor, final String nomePersonagem, final String descricaoPersonagem, final TipoAtuacao tipoAtuacao) throws Exception {

        if (idAtor == null) {
            throw new CampoObrigatorioException("idAtor.");
        }

        if (nomePersonagem == null) {
            throw new CampoObrigatorioException("nomePersonagem.");
        }

        if (descricaoPersonagem == null) {
            throw new CampoObrigatorioException("descricaoPersonagem.");
        }

        if (tipoAtuacao == null) {
            throw new CampoObrigatorioException("tipoAtuacao.");
        }
    }
}
