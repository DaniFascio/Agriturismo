package it.faraday.agriturismo.repositories;

import it.faraday.agriturismo.models.PrenotazioneSoggiorno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrenotazioneSoggiornoRepository extends CrudRepository<PrenotazioneSoggiorno,Integer> {

}
