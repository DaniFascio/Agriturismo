package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.PrenotazioneEscursione;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneEscursioneRepository extends CrudRepository<PrenotazioneEscursione,Integer> {

}
