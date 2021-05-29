package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.AttivitaIppica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttivitaIppicaRepository extends CrudRepository<AttivitaIppica,Integer> {


}
