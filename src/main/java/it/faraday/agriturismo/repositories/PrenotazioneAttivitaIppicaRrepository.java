package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.OrdinazionePizza;
import it.faraday.agriturismo.models.PrenotazioneAttivitaIppica;
import it.faraday.agriturismo.models.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneAttivitaIppicaRrepository extends CrudRepository<PrenotazioneAttivitaIppica,Integer> {

	@Query("select pai from PrenotazioneAttivitaIppica pai where pai.utente=?1")
	Iterable<PrenotazioneAttivitaIppica> prenotazioneAttivitaIppica(Utente utente);

}
