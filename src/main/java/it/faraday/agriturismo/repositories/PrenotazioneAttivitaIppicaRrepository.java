package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.PrenotazioneAttivitaIppica;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneAttivitaIppicaRrepository extends CrudRepository<PrenotazioneAttivitaIppica,Integer> {

}
