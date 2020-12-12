package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;
import studsluzba.model.TokStudijaDrziPredmet;

public interface TokStudijaDrziPredmetRepository extends CrudRepository<TokStudijaDrziPredmet, Integer>{
	
	@Query("select sdp.drziPredmet.predmet from TokStudijaDrziPredmet sdp where sdp.tokStudija.studIndex = :s")
	public List<Predmet> findPredmetByStudent(StudIndex s);

}
