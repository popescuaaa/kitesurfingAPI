package app.kitesurfing.repositories;
import app.kitesurfing.entities.Spot;
import org.springframework.data.repository.CrudRepository;


public interface SpotsRepository extends CrudRepository<Spot, Integer> {

}
