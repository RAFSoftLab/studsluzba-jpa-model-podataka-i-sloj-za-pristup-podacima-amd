package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.StudIndex;
import studsluzba.model.UpisGodine;

public interface UpisGodineRepository extends CrudRepository<UpisGodine, Integer>{
	
	@Query("select ug from UpisGodine ug join TokStudija ts on(ug.tokStudija = ts) where ts.studIndex = :si")
	List<UpisGodine> findByStudIndex(StudIndex si);

}
