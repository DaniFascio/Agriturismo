package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.Escursione;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscursioneRepository extends CrudRepository<Escursione,Integer> {

}
