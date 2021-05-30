package it.faraday.agriturismo.repositories;
import it.faraday.agriturismo.models.Utente;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends CrudRepository <Utente, Integer>{

	@Query("select u from Utente u where u.username=?1")
	Optional<Utente> findByUsername(String username);

}
