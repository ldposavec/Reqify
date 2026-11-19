package hr.algebra.rdojauf.lposavec.reqify.repository;
import hr.algebra.rdojauf.lposavec.reqify.model.CvExtraction;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Primary
@Repository
public interface CvExtractionRepository extends JpaRepository<CvExtraction, Integer> {}
