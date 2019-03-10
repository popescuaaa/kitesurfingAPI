package app.kitesurfing.repositories;
import app.kitesurfing.entities.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Integer> {

}
