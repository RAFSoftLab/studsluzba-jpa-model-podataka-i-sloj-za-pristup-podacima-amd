package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.StudIndex;
import studsluzba.model.TokStudija;

public interface TokStudijaRepository extends CrudRepository<TokStudija, Integer> {

	@Query("select a from TokStudija a where a.studIndex = :si")
	TokStudija getTokStudijaZaIndex(StudIndex si);

}
