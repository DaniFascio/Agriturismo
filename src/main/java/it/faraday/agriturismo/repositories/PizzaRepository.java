package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends CrudRepository<Pizza,Integer> {


}
