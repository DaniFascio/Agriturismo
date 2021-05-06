package AgriturismoWebsite.repositories;
import AgriturismoWebsite.models.Carrello;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CameraRepository extends CrudRepository<Carrello,Integer> {
}
