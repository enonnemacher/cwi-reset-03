package br.com.cwi.reset.projeto1.repository;

import br.com.cwi.reset.projeto1.domain.Ator;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface AtorRepositoryBd {

    Ator save(Ator ator);

    Ator findByNome(String nome);

    Ator findById(Integer id);

    List<Ator> findByOscar(Integer numeroOscars);

    void delete(Integer id);
}
