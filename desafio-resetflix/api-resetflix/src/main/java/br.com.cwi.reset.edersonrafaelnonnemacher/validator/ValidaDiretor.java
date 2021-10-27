package br.com.cwi.reset.edersonrafaelnonnemacher.validator;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.MesmoNomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.anoAtividadeMaiorNascimentoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.dataNascimentoMaiorException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.diretorSemSobrenomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Diretor;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.DiretorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class ValidaDiretor {

    @Autowired
    private DiretorRepository diretorRepository;

    public void accept(final String nome, final LocalDate dataNascimento, final Integer anoInicioAtividade, final TipoDominioException tipoDominioException) throws Exception {

        if (nome.split("").length < 2) {
            throw new diretorSemSobrenomeException(tipoDominioException.getSingular());
        }

        if (LocalDate.now().isBefore(dataNascimento)) {
            throw new dataNascimentoMaiorException(tipoDominioException.getPlural());
        }

        if (anoInicioAtividade <= dataNascimento.getYear()) {
            throw new anoAtividadeMaiorNascimentoException(tipoDominioException.getSingular());
        }

        for (Diretor listaDeDiretores : diretorRepository.findAll()) {
            if (listaDeDiretores.getNome().equalsIgnoreCase(nome)) {
                throw new MesmoNomeException(TipoDominioException.DIRETOR.getSingular(), nome);
            }
        }
    }
}
