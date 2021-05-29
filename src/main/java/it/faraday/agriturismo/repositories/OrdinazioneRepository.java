package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.Ordinazione;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdinazioneRepository extends CrudRepository<Ordinazione,Integer> {

}
