package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.OrdinazionePiatto;
import it.faraday.agriturismo.models.OrdinazionePizza;
import it.faraday.agriturismo.models.Utente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdinazionePiattoRepository extends CrudRepository<OrdinazionePiatto,Integer> {

	@Query("select op from OrdinazionePiatto op where op.utente=?1")
	Iterable<OrdinazionePiatto> ordinazioniPiatti(Utente utente);

}
