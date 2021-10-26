package br.com.cwi.reset.edersonrafaelnonnemacher.repository;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Estudio;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

    Estudio save(Estudio estudio);

    List<Estudio> findAll();
}