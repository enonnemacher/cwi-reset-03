package br.com.cwi.reset.edersonrafaelnonnemacher.validator;

import br.com.cwi.reset.edersonrafaelnonnemacher.exception.MesmoNomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.TipoDominioException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.anoAtividadeMaiorNascimentoException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.atorSemSobrenomeException;
import br.com.cwi.reset.edersonrafaelnonnemacher.exception.dataNascimentoMaiorException;
import br.com.cwi.reset.edersonrafaelnonnemacher.model.Ator;
import br.com.cwi.reset.edersonrafaelnonnemacher.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Locale;

public class ValidaAtor {

    @Autowired
    private AtorRepository atorRepository;

    public void accept(final String nome, final LocalDate dataNascimento, final Integer anoInicioAtividade, final TipoDominioException tipoDominioException) throws Exception {

        if (nome.split("").length < 2) {
            throw new atorSemSobrenomeException(tipoDominioException.getSingular());
        }

        if (LocalDate.now().isBefore(dataNascimento)) {
            throw new dataNascimentoMaiorException(tipoDominioException.getPlural());
        }

        if (anoInicioAtividade <= dataNascimento.getYear()) {
            throw new anoAtividadeMaiorNascimentoException(tipoDominioException.getSingular());
        }

        for (Ator listaDeAtores : atorRepository.findAll()) {
            if (listaDeAtores.getNome().toLowerCase(Locale.ROOT).equalsIgnoreCase(nome.toLowerCase(Locale.ROOT))) {
                throw new MesmoNomeException(TipoDominioException.ATOR.getSingular(), nome);
            }
        }
    }
}
