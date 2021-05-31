package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.OrdinazionePizza;
import it.faraday.agriturismo.models.Utente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface OrdinazionePizzaRepository extends CrudRepository<OrdinazionePizza,Integer> {

	@Query("select op from OrdinazionePizza op where op.utente=?1")
	Iterable<OrdinazionePizza> ordinazioniPizze(Utente utente);

	@Transactional
	@Modifying
	@Query("DELETE FROM OrdinazionePizza WHERE utente = ?1")
	void deleteAllByUtente(Utente utente);

}
