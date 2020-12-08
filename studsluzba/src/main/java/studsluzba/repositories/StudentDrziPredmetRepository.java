package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Predmet;
import studsluzba.model.StudIndex;
import studsluzba.model.StudentDrziPredmet;

public interface StudentDrziPredmetRepository extends CrudRepository<StudentDrziPredmet, Integer>{

	@Query("select sdp.drziPredmet.predmet from StudentDrziPredmet sdp where sdp.studIndex = :s")
	public List<Predmet> findPredmetByStudent(StudIndex s);
	
}
