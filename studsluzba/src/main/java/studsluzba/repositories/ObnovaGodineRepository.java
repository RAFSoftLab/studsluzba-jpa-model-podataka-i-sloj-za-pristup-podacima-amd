package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.ObnovaGodine;
import studsluzba.model.StudIndex;

public interface ObnovaGodineRepository extends CrudRepository<ObnovaGodine, Integer>{
	@Query("select og from ObnovaGodine og join TokStudija ts on(og.tokStudija = ts) where ts.studIndex = :si")
	List<ObnovaGodine> findByStudIndex(StudIndex si);

}
