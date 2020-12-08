package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.PredmetStudprogram;
import studsluzba.model.Studprogram;
import studsluzba.model.Predmet;

public interface PredmetStudprogramRepository extends CrudRepository<PredmetStudprogram, Integer>{
	
	@Query("select psp.predmet from PredmetStudprogram psp where psp.studProgram = :sp")
	List<Predmet> findPredmetByStudprogram(Studprogram sp);
	
	@Query("select psp.studProgram from PredmetStudprogram psp where psp.predmet = :p")
	List<Studprogram> findStudprogramByPredmet(Predmet p);
}
