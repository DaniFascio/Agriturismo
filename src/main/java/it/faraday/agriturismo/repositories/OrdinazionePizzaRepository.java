package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.OrdinazionePizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdinazionePizzaRepository extends CrudRepository<OrdinazionePizza,Integer> {

}
