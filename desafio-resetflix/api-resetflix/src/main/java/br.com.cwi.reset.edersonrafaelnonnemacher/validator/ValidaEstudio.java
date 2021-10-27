package br.com.cwi.reset.edersonrafaelnonnemacher.validator;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.MesmoNomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.dataCriacaoMaiorDataAtualException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Estudio;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ValidaEstudio {

    @Autowired
    private EstudioRepository estudioRepository;

    public void accept(final String nome, final LocalDate dataCriacao, final TipoDominioException tipoDominioException) throws Exception {

        for (Estudio listaEstudios : estudioRepository.findAll()) {
            if (listaEstudios.getNome().equalsIgnoreCase(nome)) {
                throw new MesmoNomeException(TipoDominioException.ESTUDIO.getSingular(), nome);
            }
        }

        if (LocalDate.now().isBefore(dataCriacao)) {
            throw new dataCriacaoMaiorDataAtualException(tipoDominioException.getPlural());
        }
    }
}
