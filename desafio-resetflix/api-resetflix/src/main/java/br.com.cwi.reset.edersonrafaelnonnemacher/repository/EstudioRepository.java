package br.com.cwi.reset.edersonrafaelnonnemacher.repository;

import br.com.cwi.reset.edersonrafaelnonnemacher.model.Estudio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudioRepository extends CrudRepository<Estudio, Integer> {

    Estudio save(Estudio estudio);

    List<Estudio> findAll();
}