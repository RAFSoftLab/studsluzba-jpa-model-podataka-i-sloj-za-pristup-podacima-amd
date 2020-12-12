package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.PolozenPredmet;
import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;

public interface PolozenPredmetRepository  extends CrudRepository<PolozenPredmet, Integer>{

	@Query("select pp.predmet from PolozenPredmet pp where pp.studIndex = :si")
	List<Predmet> findPredmetByStudIndex(StudIndex si);
}
