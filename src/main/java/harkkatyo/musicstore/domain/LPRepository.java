package harkkatyo.musicstore.domain;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
public interface LPRepository extends CrudRepository<LP, Long> {
	List<LP> findByTitle(String title);

}
