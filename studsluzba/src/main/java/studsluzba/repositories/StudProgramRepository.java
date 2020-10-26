package studsluzba.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.Predmet;
import studsluzba.model.Studprogram;

public interface StudProgramRepository extends CrudRepository<Studprogram, Integer>{
	
	@Query("select p from Predmet p where p.studProgram.skraceniNaziv like :nazivStudPrograma")
	List<Predmet> selectSubOnSubProg(String nazivStudPrograma);
	
}
