package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.Escursione;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetaRepository extends CrudRepository<Escursione.Meta,Integer> {

}
