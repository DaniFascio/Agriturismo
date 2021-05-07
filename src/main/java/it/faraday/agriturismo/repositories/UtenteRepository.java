package it.faraday.agriturismo.repositories;
import it.faraday.agriturismo.models.Utente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtenteRepository extends CrudRepository <Utente, Integer>{
}
