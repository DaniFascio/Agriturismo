package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.OrdinazionePiatto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdinazionePiattoRepository extends CrudRepository<OrdinazionePiatto,Integer> {

}
