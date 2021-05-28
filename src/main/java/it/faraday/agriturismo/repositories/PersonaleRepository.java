package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.Personale;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaleRepository extends CrudRepository<Personale,Integer> {

}
