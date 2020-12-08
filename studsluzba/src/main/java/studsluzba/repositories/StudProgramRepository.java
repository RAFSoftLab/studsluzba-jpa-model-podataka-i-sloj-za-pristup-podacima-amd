package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Predmet;
import studsluzba.model.Studprogram;

public interface StudProgramRepository extends CrudRepository<Studprogram, Integer>{
	
//	@Query("select p from Predmet p where p.studProgram.idstudProgram = :id")
//	List<Predmet> selectSubOnSubProg(Integer id);
//	
//	@Query("select sp from Studprogram sp join fetch sp.predmeti where sp.idstudProgram like :id")
//	Studprogram getStudprogramWithPredmeti(Integer id);
	
}
