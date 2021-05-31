package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.PrenotazioneAttivitaIppica;
import it.faraday.agriturismo.models.PrenotazioneSoggiorno;
import it.faraday.agriturismo.models.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneSoggiornoRepository extends CrudRepository<PrenotazioneSoggiorno,Integer> {


	@Query("select ps from PrenotazioneSoggiorno ps where ps.utente=?1")
	Iterable<PrenotazioneSoggiorno> prenotazioneSoggiorno(Utente utente);
}
