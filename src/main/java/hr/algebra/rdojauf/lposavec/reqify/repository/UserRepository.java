package hr.algebra.rdojauf.lposavec.reqify.repository;
import hr.algebra.rdojauf.lposavec.reqify.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {}
