package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.Camera;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCameraRepository extends CrudRepository<Camera.Tipo,Integer> {

}
