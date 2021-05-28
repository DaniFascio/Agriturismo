package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.Piatto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PiattoRepository extends CrudRepository<Piatto,Integer> {


}
