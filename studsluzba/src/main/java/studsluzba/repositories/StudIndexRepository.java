package studsluzba.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import studsluzba.model.StudIndex;
import studsluzba.model.Student;

public interface StudIndexRepository extends CrudRepository<StudIndex, Integer>{
	
	@Query("select si from StudIndex si where si.student = :s and si.aktivan=1")
	StudIndex getActiveIndexForStud(Student s);
/*
	@Query("update StudIndex si set aktivan=0 where si.idstudent = (select s from Student s where (:ime is null or lower(s.ime) like :ime) or "
			+ "(:prezime is null or lower(s.prezime) like :prezime))")
	StudIndex updateStudentIndex(String ime, String prezime);
*/
}
