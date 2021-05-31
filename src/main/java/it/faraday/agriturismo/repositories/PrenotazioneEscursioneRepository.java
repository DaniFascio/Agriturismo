package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.PrenotazioneAttivitaIppica;
import it.faraday.agriturismo.models.PrenotazioneEscursione;
import it.faraday.agriturismo.models.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneEscursioneRepository extends CrudRepository<PrenotazioneEscursione,Integer> {

	@Query("select pe from PrenotazioneEscursione pe where pe.utente=?1")
	Iterable<PrenotazioneEscursione> prenotazioneEscursione(Utente utente);

}
